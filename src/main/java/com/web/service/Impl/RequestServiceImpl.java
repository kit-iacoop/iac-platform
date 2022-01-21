package com.web.service.Impl;

import com.domain.collaboRequest.CollaboRequest;
import com.domain.collaboRequest.CollaboRequestRepository;
import com.domain.collaboRequestProfessor.CollaboRequestProfessor;
import com.domain.collaboRequestTechnique.CollaboRequestTechnique;
import com.web.dto.CollaboRequestDTO;
import com.web.service.RequestService;
import org.springframework.stereotype.Service;

import java.util.*;

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
            list.add(new CollaboRequestDTO(request));
        }

        return list;
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
}
