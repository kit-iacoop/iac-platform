package com.web.service.Impl;

import com.domain.gradePolicy.GradePolicy;
import com.domain.gradePolicy.GradePolicyRepository;
import com.web.service.GradePolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GradePolicyServiceImpl implements GradePolicyService {

    private final GradePolicyRepository gradePolicyRepository;

    @Override
    public List<GradePolicy> findAll() {
        return gradePolicyRepository.findAll();
    }
}
