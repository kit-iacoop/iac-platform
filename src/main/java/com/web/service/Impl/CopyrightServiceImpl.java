package com.web.service.Impl;

import com.domain.account.Account;
import com.domain.account.AccountRepository;
import com.domain.applicationRegistration.ApplicationRegistration;
import com.domain.common.CopyrightType;
import com.domain.common.State;
import com.domain.copyright.Copyright;
import com.domain.copyright.CopyrightRepository;
import com.web.dto.CopyrightDTO;
import com.web.service.CopyrightService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CopyrightServiceImpl implements CopyrightService {

    private final CopyrightRepository copyrightRepository;
    private final AccountRepository accountRepository;


    @Override
    public Page<CopyrightDTO> findCopyright(Pageable pageable) {
        Page<Copyright> list = copyrightRepository.findAll(pageable);
        return list.map(CopyrightDTO::new);
    }

    @Override
    public Page<CopyrightDTO> findCopyrightByKey(Pageable pageable, String title) {
        Page<Copyright> list = copyrightRepository.findByTitleContaining(pageable, title);
        return list.map(CopyrightDTO::new);
    }

    @Override
    public CopyrightDTO findCopyrightDetail(String id) {
        Optional<Copyright> byId = copyrightRepository.findById(Long.valueOf(id));
        return byId.map(CopyrightDTO::new).orElse(null);
    }

    @Override
    public void insertNewCopyright(CopyrightDTO dto) {

        Copyright copyright = Copyright.builder()
                .declarationYear(dto.getDeclarationYear())
                .cooperation(dto.getCooperation())
                .copyrightType(CopyrightType.valueOf(dto.getCopyrightType()))
                .state(State.PENDING.toString())
                .title(dto.getCopyrightName())
                .representor(dto.getRepresentor())
                .professorDepartment(dto.getProfessorDept())
                .professorName(dto.getProfessorName())
                .keyword(dto.getKeyword())
                .description(dto.getDescription())
                .maintenanceState(dto.getMaintenanceState())
                .applicationRegistrationList(new ArrayList<>())
                .build();

        Optional<Account> maybeAccount = accountRepository.findById(Long.valueOf(dto.getAccountId()));
        maybeAccount.ifPresent(copyright::setAccount);

        ApplicationRegistration applic = ApplicationRegistration.builder()
                .issueDate(LocalDate.parse(dto.getApplicationDate()))
                .number(dto.getApplicationNumber())
                .type("출원")
                .build();
        applic.setCopyright(copyright);

        if (!dto.getRegistrationDate().isEmpty() & !dto.getRegistrationNumber().isEmpty()) {
            ApplicationRegistration regist = ApplicationRegistration.builder()
                    .issueDate(LocalDate.parse(dto.getRegistrationDate()))
                    .number(dto.getRegistrationNumber())
                    .type("등록")
                    .build();
            regist.setCopyright(copyright);
        }

        copyrightRepository.save(copyright);
    }
}
