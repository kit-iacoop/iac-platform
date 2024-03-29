package com.domain.proofFile;

import com.domain.projectOutput.ProjectOutput;
import com.domain.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@SuperBuilder

@Table(name = "PROOF_FILE")
public class ProofFile extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROOF_FILE_ID", nullable = false)
    private Long proofFileId;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_OUTPUT_ID", nullable = false)
    private ProjectOutput projectOutput;

    @Column(name = "FILE_NAME", nullable = false)
    private String fileName;

    @Column(name = "FILE_PATH", nullable = false)
    private String filePath;

    @Column(name = "FILE_SIZE", nullable = false)
    private String fileSize;

    public void setProjectOutput(ProjectOutput projectOutputId) {
        if (this.projectOutput != null) {
            this.projectOutput.getProofFileList().remove(this);
        }
        this.projectOutput = projectOutputId;
        projectOutputId.getProofFileList().add(this);
    }
}
