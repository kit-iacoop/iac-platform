package com.web.service;

import com.web.dto.CollaboRequestDTO;

import java.util.List;

public interface RequestService {

    List<CollaboRequestDTO> findAllRequest();

}
