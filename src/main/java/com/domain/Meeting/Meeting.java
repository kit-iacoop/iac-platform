package com.domain.Meeting;

import com.domain.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "MEETING", schema = "iac_platform-test")
public class Meeting extends BaseTimeEntity {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "MEETING_ID", nullable = false)
   private Long meetingId;

   @Column(name = "COLLABO_REQUEST_ID", nullable = false)
   private Long collaboRequestId;

   @Column(name = "PROJECT_ID", nullable = false)
   private Long projectId;

   @Column(name = "MEETING_LOCATION", nullable = false)
   private String meetingLocation;

   @Column(name = "MEETING_NAME", nullable = false)
   private String meetingName;

   @Column(name = "MEETING_DATE", nullable = false)
   private java.time.LocalDate meetingDate;

   @Column(name = "MEETING_TIME", nullable = false)
   private String meetingTime;

   @Column(name = "MEETING_TYPE", nullable = false)
   private String meetingType;


}
