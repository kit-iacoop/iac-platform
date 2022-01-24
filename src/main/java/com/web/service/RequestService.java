package com.web.service;

import com.domain.common.RequestType;
import com.web.dto.CollaboRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RequestService {

    Page<CollaboRequestDTO> findRequestByTypeAndKey(String type, String key, Pageable pageable);

    CollaboRequestDTO getRequestDetail(String id);

    int insertNewRequest(CollaboRequestDTO collaboRequestDTO);

}
