package com.domain.ProjectOutput;

import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "PROJECT_OUTPUT", schema = "iac_platform-test")
public class ProjectOutput extends BaseTimeEntity {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "PROJECT_OUTPUT_ID", nullable = false)
   private Long projectOutputId;

   @Column(name = "PROJECT_ID", nullable = false)
   private Long projectId;

   @Column(name = "OUTPUT_TYPE", nullable = false)
   private String outputType;

   @Column(name = "DESCRIPTION", nullable = false)
   private String description;

   @Column(name = "STATUS", nullable = false)
   private String status;


}
