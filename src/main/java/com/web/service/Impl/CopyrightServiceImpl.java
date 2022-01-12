package com.web.service.Impl;

import com.domain.copyright.Copyright;
import com.domain.copyright.CopyrightRepository;
import com.web.dto.CopyrightDTO;
import com.web.service.CopyrightService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor

@Service
public class CopyrightServiceImpl implements CopyrightService {

    private final CopyrightRepository copyrightRepository;
    
    @Override
    public List<CopyrightDTO> findCopyright() {
        List<Copyright> all = copyrightRepository.findAll();
        List<CopyrightDTO> dtoList = new ArrayList<>();
        for (Copyright e : all) {
            dtoList.add(new CopyrightDTO(e));
        }
        return dtoList;
    }
}
