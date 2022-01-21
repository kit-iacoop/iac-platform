package com.domain.gradePolicy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GradePolicyRepository extends JpaRepository<GradePolicy, Long> {
    GradePolicy findByGrade(String grade);
}
