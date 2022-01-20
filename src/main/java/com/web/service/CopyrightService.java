package com.web.service;

import com.web.dto.CopyrightDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CopyrightService {
    Page<CopyrightDTO> findCopyright(Pageable pageable);

    Page<CopyrightDTO> findCopyrightByKey(Pageable pageable, String title);

    CopyrightDTO findCopyrightDetail(String id);

    void insertNewCopyright(CopyrightDTO dto);
}
