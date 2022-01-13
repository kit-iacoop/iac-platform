package com.web.service;

import com.web.dto.CopyrightDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CopyrightService {
    List<CopyrightDTO> findCopyright(Pageable pageable);

    List<CopyrightDTO> findCopyrightByKey(Pageable pageable, String title);
}
