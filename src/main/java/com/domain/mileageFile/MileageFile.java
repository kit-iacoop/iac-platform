package com.domain.mileageFile;

import com.domain.companyMileage.CompanyMileage;
import com.domain.common.BaseTimeEntity;

import com.domain.common.FileDetails;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
   @JoinColumn(name = "COMPANY_MILEAGE_ID", nullable = false)
   private CompanyMileage companyMileage;

   @Embedded
   private FileDetails address;

}
