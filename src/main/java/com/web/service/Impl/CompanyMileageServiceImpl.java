package com.web.service.Impl;

import com.common.Common;
import com.domain.account.Company;
import com.domain.collaborationCategory.CollaborationCategory;
import com.domain.collaborationCategory.CollaborationCategoryRepository;
import com.domain.common.State;
import com.domain.companyMileage.CompanyMileage;
import com.domain.companyMileage.CompanyMileageRepository;
import com.domain.mileagePolicy.MileagePolicy;
import com.domain.mileagePolicy.MileagePolicyRepository;
import com.web.dto.mileage.MileageHistoryDTO;
import com.web.dto.mileage.QueryOptionDTO;
import com.web.service.CollaborationCategoryService;
import com.web.service.CompanyMileageService;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class CompanyMileageServiceImpl implements CompanyMileageService {

    private final CompanyMileageRepository companyMileageRepository;
    private final MileagePolicyRepository mileagePolicyRepository;
    private final CollaborationCategoryRepository collaborationCategoryRepository;
    private final Common common;


    @Override
    public List<MileageHistoryDTO> findAllHistoryDTOByCompanyIdAndDOption(Long accountId, QueryOptionDTO queryOptionDTO) {
        return companyMileageRepository.findAllHistoryDTOByCompanyIdAndDOption(accountId, queryOptionDTO);
    }

    @Override
    public List<MileageHistoryDTO> findAllHistoryDTOWithDOption(QueryOptionDTO queryOptionDTO) {
        return companyMileageRepository.findAllHistoryDTOWithDOption(queryOptionDTO);
    }

    @Transactional
    @Override
    public void acceptMileage(Long id) {

        CompanyMileage cm = companyMileageRepository.findByCompanyMileageId(id);
        cm.accept();

    }

    @Transactional
    @Override
    public void rejectMileage(Long id) {

        CompanyMileage cm = companyMileageRepository.findByCompanyMileageId(id);
        cm.reject();

    }

    @Transactional
    @Override
    public void createCompanyMileage(Long midCtg, Long cnt, LocalDateTime start, LocalDateTime end) {

        CollaborationCategory cc = collaborationCategoryRepository.findByCollaborationCategoryId(midCtg);
        MileagePolicy mp = mileagePolicyRepository.findByCollaborationCategory(cc);

        CompanyMileage cm =  CompanyMileage.builder()
                .mileagePolicy(mp)
                .company((Company) common.getAccount())
                .achievementCnt(cnt)
                .startDate(start)
                .endDate(end)
                .status(State.PENDING)
                .build();

        companyMileageRepository.save(cm);

    }

    @Override
    public MileageHistoryDTO findHistoryDTOById(Long activityId) {
        return companyMileageRepository.findHistoryDTOById(activityId);
    }
}
