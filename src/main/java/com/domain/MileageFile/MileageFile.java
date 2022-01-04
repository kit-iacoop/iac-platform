package com.domain.MileageFile;

import com.domain.MileageRequest.MileageRequest;
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

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "MILEAGE_REQUEST_ID", nullable = false)
   private MileageRequest mileageRequest;

   @Embedded
   private FileDetails address;

}
