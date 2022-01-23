package com.web.dto;

import com.domain.proofFile.ProofFile;
import com.domain.salesHistoryProofFile.SalesHistoryProofFile;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProofFileDTO {
    // 매출 내역 증빙 파일인 경우 salesHistoryProofFileId
    // 산출물 증빙 파일인 경우 proofFileId
    private String proofFileId;

    // 매출 내역 증빙 파일인 경우
    private String projectSalesHistoryId;
    // 프로젝트 산출물 증빙 파일인 경우
    private String projectOutputId;

    private String fileName;
    private String filePath;
    private String fileSize;

    // proofFile entity to DTO
    public ProofFileDTO(ProofFile proofFile) {
        this.proofFileId = String.valueOf(proofFile.getProofFileId());
        this.projectOutputId = String.valueOf(proofFile.getProjectOutput().getProjectOutputId());
        this.fileName = proofFile.getFileName();
        this.filePath = proofFile.getFilePath();
        this.fileSize = proofFile.getFileSize();
    }

    // salesHistoryProofFile entity to DTO
    public ProofFileDTO(SalesHistoryProofFile salesHistoryProofFile) {
        this.proofFileId = String.valueOf(salesHistoryProofFile.getSalesHistoryProofFileId());
        this.projectSalesHistoryId = String.valueOf(salesHistoryProofFile.getProjectSalesHistory().getProjectSalesHistoryId());
        this.fileName = salesHistoryProofFile.getFileName();
        this.filePath = salesHistoryProofFile.getFilePath();
        this.fileSize = salesHistoryProofFile.getFileSize();
    }
}