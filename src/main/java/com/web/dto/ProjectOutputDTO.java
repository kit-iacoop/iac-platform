package com.web.dto;

import com.domain.projectOutput.ProjectOutput;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectOutputDTO {

    private String projectOutputId;
    private String projectId;
    private String outputType;
    private String description;
    private String status;

    private List<ProofFileDTO> proofFileDTOList;

    public ProjectOutputDTO(ProjectOutput projectOutput) {
        this.projectOutputId = String.valueOf(projectOutput.getProjectOutputId());
        this.projectId = String.valueOf(projectOutput.getProject().getProjectId());
        this.outputType = String.valueOf(projectOutput.getOutputType());
        this.description = projectOutput.getDescription();
        this.status = String.valueOf(projectOutput.getStatus());

        this.proofFileDTOList = projectOutput.getProofFileList().stream().map(ProofFileDTO::new).collect(Collectors.toList());
    }
}
