package com.domain.proofFile;

import com.domain.projectOutput.ProjectOutput;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProofFileRepository extends JpaRepository<ProofFile, Long> {

    List<ProofFile> findByProjectOutput(ProjectOutput projectOutput);
}
