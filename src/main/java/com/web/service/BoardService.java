package com.web.service;

import com.web.dto.NoticeBoardDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BoardService {
    void insertBoard(NoticeBoardDTO dto);

    Page<NoticeBoardDTO> findAllBoard(Pageable pageable, String key);
}
