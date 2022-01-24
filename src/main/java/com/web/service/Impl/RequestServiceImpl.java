package com.web.service.Impl;

import com.domain.account.*;
import com.domain.collaboRequest.CollaboRequest;
import com.domain.collaboRequest.CollaboRequestRepository;
import com.domain.common.RequestType;
import com.domain.common.State;
import com.domain.fieldCategory.FieldCategory;
import com.domain.fieldCategory.FieldCategoryRepository;
import com.security.service.AccountContext;
import com.web.dto.CollaboRequestDTO;
import com.web.service.RequestService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RequestServiceImpl implements RequestService {

    private final CollaboRequestRepository collaboRequestRepository;
    private final OfficerRepository officerRepository;
    private final CompanyRepository companyRepository;

    public RequestServiceImpl(CollaboRequestRepository collaboRequestRepository, OfficerRepository officerRepository, CompanyRepository companyRepository) {
        this.collaboRequestRepository = collaboRequestRepository;
        this.officerRepository = officerRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public Page<CollaboRequestDTO> findRequestByTypeAndKey(String type, String key, Pageable pageable) {

        switch (type) {
            case "all":
                return collaboRequestRepository.findAll(pageable).map(CollaboRequestDTO::new);
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

        CollaboRequest request = CollaboRequest.builder()
                .officer(maybeOfficer.get())
                .company(maybeCompany.get())
                .title(collaboRequestDTO.getTitle())
                .budget(collaboRequestDTO.getBudget())
                .term(collaboRequestDTO.getTerm())
                .expireDate(LocalDate.parse(collaboRequestDTO.getExpireDate()))
                .description(collaboRequestDTO.getDescription())
                .status(State.valueOf(collaboRequestDTO.getStatus()))
                .requestType(RequestType.valueOf(collaboRequestDTO.getRequestType()))
                .collaboRequestProfessorList(collaboRequestDTO.getCollaboRequestProfessorList())
                .collaboRequestTechniqueList(collaboRequestDTO.getCollaboRequestTechniqueList())
                .meetingList(collaboRequestDTO.getMeetingList())
                .isCapstone(collaboRequestDTO.getIsCapstone())
                .build();

        collaboRequestRepository.save(request);
        return 1;
    }
}
