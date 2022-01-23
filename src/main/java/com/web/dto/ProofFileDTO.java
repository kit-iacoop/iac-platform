package com.web.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProofFileDTO {

    private String proofFileId;
    private String projectOutputId;
    private String fileName;
    private String filePath;
    private String fileSize;
}
