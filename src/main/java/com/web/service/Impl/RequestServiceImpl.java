package com.web.service.Impl;

import com.domain.collaboRequest.CollaboRequest;
import com.domain.collaboRequest.CollaboRequestRepository;
import com.domain.collaboRequestProfessor.CollaboRequestProfessor;
import com.domain.collaboRequestTechnique.CollaboRequestTechnique;
import com.web.dto.CollaboRequestDTO;
import com.web.service.RequestService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RequestServiceImpl implements RequestService {

    private final CollaboRequestRepository collaboRequestRepository;

    public RequestServiceImpl(CollaboRequestRepository collaboRequestRepository) {
        this.collaboRequestRepository = collaboRequestRepository;
    }


    @Override
    public List<CollaboRequestDTO> findAllRequest() {

        List<CollaboRequest> all = collaboRequestRepository.findAll();
        List<CollaboRequestDTO> list = new ArrayList<>();

        for (CollaboRequest request : all) {
            Map<String, String> profList = new HashMap<>();
            Map<String, String> techList = new HashMap<>();

            List<CollaboRequestProfessor> professors = request.getCollaboRequestProfessorList();
            List<CollaboRequestTechnique> techniques = request.getCollaboRequestTechniqueList();

            for (CollaboRequestProfessor e : professors) {
                profList.put(String.valueOf(e.getProfessor().getAccountId()), e.getProfessor().getName());
            }
            for (CollaboRequestTechnique e : techniques) {
                techList.put(String.valueOf(e.getFieldCategory().getFieldCategoryId()), e.getFieldCategory().getCategoryName());
            }

            list.add(CollaboRequestDTO.builder()
                    .collaboRequestId(String.valueOf(request.getCollaboRequestId()))
                    .officerId(String.valueOf(request.getOfficer().getAccountId()))
                    .officerName(request.getOfficer().getName())
                    .companyId(String.valueOf(request.getCompany().getAccountId()))
                    .companyName(request.getCompany().getName())
                    .title(request.getTitle())
                    .term(request.getTerm())
                    .expireDate(String.valueOf(request.getExpireDate()))
                    .description(request.getDescription())
                    .status(String.valueOf(request.getStatus()))
                    .requestType(String.valueOf(request.getRequestType()))
                    .budget(request.getBudget())
                    .projectId(String.valueOf(request.getProjectId()))
                    .collaboRequestProfessorList(profList)
                    .collaboRequestTechniqueList(techList)
                    .meetingList(request.getMeetingList())
                    .build()
            );
        }

        return list;
    }
}
