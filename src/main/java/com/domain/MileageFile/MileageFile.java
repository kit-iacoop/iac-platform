package com.domain.MileageFile;

import com.domain.common.BaseTimeEntity;

import com.domain.common.FileDetails;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.File;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "MILEAGE_FILE")
public class MileageFile extends BaseTimeEntity {

   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "MILEAGE_FILE_ID", nullable = false, unique = true)
   private Long mileageFileId;

   @Column(name = "MILEAGE_REQUEST_ID", nullable = false)
   private Long mileageRequestId;

   @Embedded
   private FileDetails address;

}
