package com.domain.companyMileage;

import com.domain.account.Company;
import com.domain.account.Officer;
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
import java.time.LocalDateTime;
import java.util.List;

@SuperBuilder
@NoArgsConstructor
@ToString(exclude={"officer", "company", "mileagePolicy", "mileageFileList"})
@Getter
@Entity
@Table(name = "COMPANY_MILEAGE")
public class CompanyMileage extends BaseTimeEntity {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "COMPANY_MILEAGE_ID", nullable = false, unique = true)
   private Long companyMileageId;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "OFFICER_ACCOUNT_ID", nullable = true)
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
   private LocalDateTime startDate;

   @Column(name = "END_DATE", nullable = false)
   private LocalDateTime endDate;

   @OneToMany(mappedBy = "companyMileage", fetch = FetchType.LAZY)
   private List<MileageFile> mileageFileList;


   public void accept(){
      company.savePoint(mileagePolicy.getPoint() * achievementCnt);
      company.saveMileage(mileagePolicy.getMileage() * achievementCnt);
      status = State.APPROVED;
   }
   public void reject(){
      status = State.REJECTED;

   }

}
