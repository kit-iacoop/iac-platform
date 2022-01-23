package com.web.service.Impl;

import com.domain.account.*;
import com.domain.collaboRequest.CollaboRequest;
import com.domain.collaboRequest.CollaboRequestRepository;
import com.domain.common.RequestType;
import com.domain.common.State;
import com.domain.fieldCategory.FieldCategory;
import com.domain.fieldCategory.FieldCategoryRepository;
import com.web.dto.CollaboRequestDTO;
import com.web.service.RequestService;
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
    public List<CollaboRequestDTO> findAllRequest() {

        List<CollaboRequest> all = collaboRequestRepository.findAll();
        return all.stream().map(CollaboRequestDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<CollaboRequestDTO> findRequestByType(RequestType type) {

        List<CollaboRequest> all = collaboRequestRepository.findAllByRequestType(type);
        return all.stream().map(CollaboRequestDTO::new).collect(Collectors.toList());
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
