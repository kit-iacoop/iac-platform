package com.domain.projectOutput;

import com.domain.project.Project;
import com.domain.proofFile.ProofFile;
import com.domain.common.BaseTimeEntity;
import com.domain.common.CopyrightType;
import com.domain.common.State;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@SuperBuilder

@Table(name = "PROJECT_OUTPUT")
public class ProjectOutput extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_OUTPUT_ID", nullable = false)
    private Long projectOutputId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PROJECT_ID", nullable = false)
    private Project project;

    @Column(name = "OUTPUT_TYPE", nullable = false)
    private String outputType; // mid, final

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private State status;

    @OneToMany(mappedBy = "projectOutput", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<ProofFile> proofFileList = new ArrayList<>();

    public void setProject(Project projectId) {
        if (this.project != null) {
            this.project.getProjectOutputList().remove(this);
        }
        this.project = projectId;
        projectId.getProjectOutputList().add(this);
    }

    public void setStatus(State status) {
        this.status = status;
    }
}
