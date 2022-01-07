package com.domain.ProofFile;

import com.domain.ProjectOutput.ProjectOutput;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProofFileRepository extends JpaRepository<ProofFile, Long> {

    List<ProofFile> findByProjectOutput(ProjectOutput projectOutput);
}
