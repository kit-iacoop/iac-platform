package com.domain.projectOutput;

import com.domain.project.Project;
import com.domain.proofFile.ProofFile;
import com.domain.common.BaseTimeEntity;
import com.domain.common.CopyrightType;
import com.domain.common.State;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "PROJECT_OUTPUT")
public class ProjectOutput extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_OUTPUT_ID", nullable = false)
    private Long projectOutputId;

    @ManyToOne
    @JoinColumn(name = "PROJECT_ID", nullable = false)
    private Project project;

    // CopyrightType 을 같이 사용해도 문제없을것같음.
    @Enumerated(EnumType.STRING)
    @Column(name = "OUTPUT_TYPE", nullable = false)
    private CopyrightType outputType;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private State status;

    @OneToMany(mappedBy = "projectOutput")
    private List<ProofFile> proofFileList = new ArrayList<>();

    public void setProject(Project projectId) {
        if (this.project != null) {
            this.project.getProjectOutputList().remove(this);
        }
        this.project = projectId;
        projectId.getProjectOutputList().add(this);
    }
}
