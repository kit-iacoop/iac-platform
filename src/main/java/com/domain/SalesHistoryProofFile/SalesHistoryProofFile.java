package com.domain.SalesHistoryProofFile;

import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "SALES_HISTORY_PROOF_FILE", schema = "iac_platform-test")
public class SalesHistoryProofFile extends BaseTimeEntity {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "SALES_HISTORY_PROOF_FILE_ID", nullable = false)
   private Long salesHistoryProofFileId;

   @Column(name = "PROJECT_SALES_HISTORY_ID", nullable = false)
   private Long projectSalesHistoryId;

   @Column(name = "FILE_NAME", nullable = false)
   private String fileName;

   @Column(name = "FILE_PATH", nullable = false)
   private String filePath;

   @Column(name = "FILE_SIZE", nullable = false)
   private String fileSize;


}
