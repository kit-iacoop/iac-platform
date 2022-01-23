package com.web.service;

import com.domain.common.RequestType;
import com.web.dto.CollaboRequestDTO;

import java.util.List;

public interface RequestService {

    List<CollaboRequestDTO> findAllRequest();

    List<CollaboRequestDTO> findRequestByType(RequestType type);

    CollaboRequestDTO getRequestDetail(String id);

    int insertNewRequest(CollaboRequestDTO collaboRequestDTO);

}
