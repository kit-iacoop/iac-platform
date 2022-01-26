package com.domain.mileageRequest;

import com.domain.account.Company;
import com.domain.account.Officer;
import com.domain.companyMileage.CompanyMileage;
import com.domain.mileageFile.MileageFile;
import com.domain.mileagePolicy.MileagePolicy;
import com.domain.common.BaseTimeEntity;

import com.domain.common.State;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@SuperBuilder
@NoArgsConstructor
@ToString(exclude={"mileageFileList", "companyMileage"})
@Getter
@Entity
@Table(name = "MILEAGE_REQUEST")
public class MileageRequest extends BaseTimeEntity {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "MILEAGE_REQUEST_ID", nullable = false, unique = true)
   private Long mileageRequestId;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "OFFICER_ACCOUNT_ID", nullable = false)
   private Officer officer;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "COMPANY_ACCOUNT_ID", nullable = false)
   private Company company;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "MILEAGE_POLICY_ID", nullable = false)
   private MileagePolicy mileagePolicy;

   @Column(name = "ACHIEVEMENT_CNT", nullable = false)
   private Long achievementCnt;

   @Column(name = "STATUS", nullable = false)
   private State status;

   @Column(name = "START_DATE", nullable = false)
   private LocalDate startDate;

   @Column(name = "END_DATE", nullable = false)
   private LocalDate endDate;

   @OneToMany(mappedBy = "mileageRequest", fetch = FetchType.LAZY)
   private List<MileageFile> mileageFileList;

   @OneToOne(mappedBy = "mileageRequest", fetch = FetchType.LAZY)
   private CompanyMileage companyMileage; //당 Request가 승인될 시 생성되는 마일리지 칼럼


}
