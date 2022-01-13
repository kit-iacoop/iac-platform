package com.web.service.Impl;

import com.domain.copyright.Copyright;
import com.domain.copyright.CopyrightRepository;
import com.web.dto.CopyrightDTO;
import com.web.service.CopyrightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CopyrightServiceImpl implements CopyrightService {

    private final CopyrightRepository copyrightRepository;

    @Autowired
    public CopyrightServiceImpl(CopyrightRepository copyrightRepository) {
        this.copyrightRepository = copyrightRepository;
    }

    @Override
    public List<CopyrightDTO> findCopyright(Pageable pageable) {
        Page<Copyright> list = copyrightRepository.findAll(pageable);
        List<CopyrightDTO> dtoList = new ArrayList<>();
        for (Copyright e : list) {
            dtoList.add(new CopyrightDTO(e));
        }
        return dtoList;
    }

    @Override
    public List<CopyrightDTO> findCopyrightByKey(Pageable pageable, String title) {
        Page<Copyright> list = copyrightRepository.findByTitleContaining(pageable, title);
        List<CopyrightDTO> dtoList = new ArrayList<>();
        for (Copyright e : list) {
            dtoList.add(new CopyrightDTO(e));
        }
        return dtoList;
    }
}
