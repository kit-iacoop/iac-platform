package com.web.service.Impl;

import com.domain.account.*;
import com.domain.collaboRequest.CollaboRequest;
import com.domain.collaboRequest.CollaboRequestRepository;
import com.domain.collaboRequest.RequestQueryCondition;
import com.domain.collaboRequestProfessor.CollaboRequestProfessor;
import com.domain.collaboRequestProfessor.CollaboRequestProfessorRepository;
import com.domain.collaboRequestTechnique.CollaboRequestTechnique;
import com.domain.common.RequestType;
import com.domain.common.State;
import com.domain.fieldCategory.FieldCategory;
import com.domain.fieldCategory.FieldCategoryRepository;
import com.domain.meeting.Meeting;
import com.domain.meeting.MeetingRepository;
import com.domain.meetingAttendant.MeetingAttendant;
import com.domain.project.ProjectRepository;
import com.security.service.AccountContext;
import com.web.dto.*;
import com.web.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class RequestServiceImpl implements RequestService {

    private final CollaboRequestRepository collaboRequestRepository;
    private final OfficerRepository officerRepository;
    private final CompanyRepository companyRepository;
    private final ProfessorRepository professorRepository;
    private final FieldCategoryRepository fieldCategoryRepository;
    private final CollaboRequestProfessorRepository collaboRequestProfessorRepository;
    private final ProjectRepository projectRepository;
    private final AccountRepository accountRepository;
    private final MeetingRepository meetingRepository;

    @Override
    public Page<CollaboRequestDTO> findRequestByTypeAndKey(String type, String key, Pageable pageable) {

        switch (type) {
            case "all":
                return collaboRequestRepository.findAllByTitleContains(key, pageable).map(CollaboRequestDTO::new);
            case "close":
                return collaboRequestRepository.findAllByRequestTypeAndTitleContains(RequestType.CLOSE, key, pageable).map(CollaboRequestDTO::new);
            case "my":
                AccountContext principal = (AccountContext) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                Long accountId = principal.getAccount().getAccountId();
                return collaboRequestRepository.findAllByCompany_AccountIdAndTitleContains(accountId, key, pageable).map(CollaboRequestDTO::new);
            case "capstone":
                return collaboRequestRepository.findAllByIsCapstoneAndTitleContains("true", key, pageable).map(CollaboRequestDTO::new);
            default:
                return collaboRequestRepository.findAllByRequestTypeAndTitleContains(RequestType.OPEN, key, pageable).map(CollaboRequestDTO::new);
        }
    }


    @Override
    public CollaboRequestDTO getRequestDetail(String id) {
        Optional<CollaboRequest> byId = collaboRequestRepository.findById(Long.valueOf(id));

        CollaboRequestDTO dto = null;
        if (byId.isPresent()) {
            dto = new CollaboRequestDTO(byId.get());
        }
        return dto;
    }

    @Override
    public int insertNewRequest(CollaboRequestDTO collaboRequestDTO) {

        Optional<Officer> maybeOfficer = officerRepository.findById(Long.valueOf(collaboRequestDTO.getOfficerId()));
        if (maybeOfficer.isEmpty()) {
            return -1;
        }

        Optional<Company> maybeCompany = companyRepository.findById(Long.valueOf(collaboRequestDTO.getCompanyId()));
        if (maybeCompany.isEmpty()) {
            return -1;
        }


        List<String> professorIdList = new ArrayList<>();
        List<CollaboRequestProfessor> professorList = new ArrayList<>();

        List<String> techniqueIdList = new ArrayList<>();
        List<CollaboRequestTechnique> techniqueList = new ArrayList<>();


        CollaboRequest request = CollaboRequest.builder()
                .officer(maybeOfficer.get())
                .company(maybeCompany.get())
                .title(collaboRequestDTO.getTitle())
                .budget(collaboRequestDTO.getBudget())
                .term(collaboRequestDTO.getTerm())
                .termType(Integer.parseInt(collaboRequestDTO.getTerm()) < 100 ? "short" : "long")
                .expireDate(LocalDate.parse(collaboRequestDTO.getExpireDate()))
                .description(collaboRequestDTO.getDescription())
                .status(State.valueOf(collaboRequestDTO.getStatus()))
                .requestType(RequestType.valueOf(collaboRequestDTO.getRequestType()))
                .collaboRequestProfessorList(professorList)
                .collaboRequestTechniqueList(techniqueList)
                .meetingList(new ArrayList<>())
                .isCapstone(collaboRequestDTO.getIsCapstone())
                .build();

        if (collaboRequestDTO.getCollaboRequestProfessorList() != null) {
            for (CollaboRequestProfessorDTO dto : collaboRequestDTO.getCollaboRequestProfessorList()) {
                professorIdList.add(dto.getProfessorId());
            }
            List<Professor> professor = professorRepository.findAllById(professorIdList.stream().map(Long::valueOf).collect(Collectors.toList()));
            for (Professor p : professor) {
                CollaboRequestProfessor build = CollaboRequestProfessor.builder().build();
                build.setProfessor(p);
                build.setCollaboRequest(request);
            }
        }

        if (collaboRequestDTO.getCollaboRequestTechniqueList() != null) {
            for (CollaboRequestTechniqueDTO dto : collaboRequestDTO.getCollaboRequestTechniqueList()) {
                techniqueIdList.add(dto.getFieldCategoryId());
            }
            List<FieldCategory> field = fieldCategoryRepository.findAllById(techniqueIdList.stream().map(Long::valueOf).collect(Collectors.toList()));
            for (FieldCategory f : field) {
                CollaboRequestTechnique build = CollaboRequestTechnique.builder().build();
                build.setFieldCategory(f);
                build.setCollaboRequest(request);
            }
        }

        collaboRequestRepository.save(request);
        return 1;
    }

    @Override
    public int closeToOpen(Long id) {
        Optional<CollaboRequest> maybeRequest = collaboRequestRepository.findById(id);
        if (maybeRequest.isPresent()) {
            CollaboRequest request = maybeRequest.get();
            request.changeTypeOpen();
            request.clearProfessorList();
            collaboRequestRepository.save(request);
            return 1;
        }

        return 0;
    }

    @Override
    public int requestAttend(Long requestId, Long professorId) {

        Optional<CollaboRequest> maybeRequest = collaboRequestRepository.findById(requestId);
        Optional<Professor> maybeProfessor = professorRepository.findById(professorId);

        if (maybeRequest.isPresent() & maybeProfessor.isPresent()) {
            CollaboRequest request = maybeRequest.get();
            Professor professor = maybeProfessor.get();

            CollaboRequestProfessor build = CollaboRequestProfessor.builder()
                    .build();
            build.setProfessor(professor);
            build.setCollaboRequest(request);


            collaboRequestProfessorRepository.save(build);
            return 1;
        }

        return 0;
    }

    @Override
    public Page<CollaboRequestDTO> findRequestByQuery(String type, String term, String[] fields, String[] options, String key, Pageable pageable) {

        List<FieldCategory> categories = fieldCategoryRepository.findAllById(Arrays.stream(fields).map(Long::valueOf).collect(Collectors.toList()));
        String isCapstone = "";
        String isFusion = "";
        for (String op : options) {
            if (op.equals("capstone")) {
                isCapstone = "true";
            } else if (op.equals("fusion")) {
                isFusion = "true";
            }
        }

        RequestQueryCondition build = RequestQueryCondition.builder()
                .type(type.equals("all") ? null : RequestType.valueOf(type.toUpperCase(Locale.ROOT)))
                .key(key)
                .termType(term)
                .fieldCategoryList(categories)
                .isCapstone(isCapstone)
                .isFusion(isFusion)
                .build();

        Page<CollaboRequest> search = collaboRequestRepository.search(build, pageable);

        return search.map(CollaboRequestDTO::new);
    }

    @Override
    public int insertNewMeeting(MeetingDTO meetingDTO) {

        Meeting meeting = Meeting.builder()
                .meetingName(meetingDTO.getMeetingName())
                .collaboRequest(collaboRequestRepository.findById(Long.valueOf(meetingDTO.getCollaboRequestId())).orElse(null))
                .project(projectRepository.findById(Long.valueOf(meetingDTO.getProjectId())).orElse(null))
                .meetingLocation(meetingDTO.getMeetingLocation())
                .meetingDate(LocalDate.parse(meetingDTO.getMeetingDate()))
                .meetingTime(meetingDTO.getMeetingTime())
                .meetingType(meetingDTO.getMeetingType())
                .build();

        List<String> accountIdList = meetingDTO.getMeetingAttendantList().stream().map(MeetingAttendantDTO::getAccountId).collect(Collectors.toList());
        List<Account> accountList = accountRepository.findAllById(accountIdList.stream().map(Long::valueOf).collect(Collectors.toList()));

        for (Account account : accountList) {
            MeetingAttendant build = MeetingAttendant.builder().build();
            build.setAccount(account);
            build.setMeeting(meeting);
        }

        meetingRepository.save(meeting);

        return 1;
    }
}