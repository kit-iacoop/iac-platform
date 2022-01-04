package com.domain.ProofFile;

import com.domain.ProjectOutput.ProjectOutput;
import com.domain.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "PROOF_FILE")
public class ProofFile extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROOF_FILE_ID", nullable = false)
    private Long proofFileId;

    @ManyToOne
    @JoinColumn(name = "PROJECT_OUTPUT_ID", nullable = false)
    private ProjectOutput projectOutputId;

    @Column(name = "FILE_NAME", nullable = false)
    private String fileName;

    @Column(name = "FILE_PATH", nullable = false)
    private String filePath;

    @Column(name = "FILE_SIZE", nullable = false)
    private String fileSize;

    public void setProjectOutput(ProjectOutput projectOutputId) {
        if (this.projectOutputId != null) {
            this.projectOutputId.getProofFileList().remove(this);
        }
        this.projectOutputId = projectOutputId;
        projectOutputId.getProofFileList().add(this);
    }
}
