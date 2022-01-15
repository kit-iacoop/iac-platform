package com.web.service;

import com.web.dto.CopyrightDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CopyrightService {
    Page<CopyrightDTO> findCopyright(Pageable pageable);

    Page<CopyrightDTO> findCopyrightByKey(Pageable pageable, String title);
}
