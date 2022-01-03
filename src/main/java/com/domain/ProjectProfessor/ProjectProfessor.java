package com.domain.ProjectProfessor;

import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "PROJECT_PROFESSOR", schema = "iac_platform-test")
public class ProjectProfessor extends BaseTimeEntity {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "PROJECT_PROFESSOR_ID", nullable = false)
   private Long projectProfessorId;

   @Column(name = "PROJECT_ID", nullable = false)
   private Long projectId;

   @Column(name = "PROFESSOR_ACCOUNT_ID", nullable = false)
   private Long professorAccountId;


}
