package com.web.dto.mileage;

import com.domain.common.State;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class MileageHistoryDTO {

    private Long companyMileageId;
    private String parentCollaborationName;
    private String collaborationName;
    private Long achievementCnt;
    private State status;
    private Long mileage;
    private Long point;
    private LocalDate startDate;
    private LocalDate endDate;
}
