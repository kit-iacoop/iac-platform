package com.web.service;

import com.web.dto.CollaboRequestDTO;

import java.util.List;

public interface RequestService {

    List<CollaboRequestDTO> findAllRequest();
    List<CollaboRequestDTO> findOpenRequest();

    CollaboRequestDTO getRequestDetail(String id);

    int insertNewRequest(CollaboRequestDTO collaboRequestDTO);

}
