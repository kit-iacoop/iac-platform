package com.web.dto;

import lombok.*;

import java.util.List;

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

}
