package com.domain.MileageFile;

import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "MILEAGE_FILE", schema = "iac_platform-test")
public class MileageFile extends BaseTimeEntity {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "MILEAGE_FILE_ID", nullable = false)
   private Long mileageFileId;

   @Column(name = "MILEAGE_REQUEST_ID", nullable = false)
   private Long mileageRequestId;

   @Column(name = "FILE_NAME", nullable = false)
   private String fileName;

   @Column(name = "FILE_PATH", nullable = false)
   private String filePath;

   @Column(name = "FILE_SIZE", nullable = false)
   private String fileSize;


}
