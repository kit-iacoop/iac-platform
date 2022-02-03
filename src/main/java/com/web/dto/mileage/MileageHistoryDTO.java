package com.web.dto.mileage;

import com.domain.common.State;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor

public class MileageHistoryDTO {

    private Long companyMileageId;
    private String companyName;
    private String parentCollaborationName;
    private String collaborationName;
    private Long achievementCnt;
    private State status;
    private Long mileage;
    private Long point;
    private LocalDate startDate;
    private LocalDate endDate;

    public MileageHistoryDTO(Long companyMileageId, String collaborationName, Long achievementCnt, State status, Long mileage, Long point, LocalDate startDate, LocalDate endDate) {
        this.companyMileageId = companyMileageId;
        this.collaborationName = collaborationName;
        this.achievementCnt = achievementCnt;
        this.status = status;
        this.mileage = mileage;
        this.point = point;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public MileageHistoryDTO(Long companyMileageId, String companyName, String collaborationName, Long achievementCnt, State status, Long mileage, Long point, LocalDate startDate, LocalDate endDate) {
        this.companyMileageId = companyMileageId;
        this.companyName = companyName;
        this.collaborationName = collaborationName;
        this.achievementCnt = achievementCnt;
        this.status = status;
        this.mileage = mileage;
        this.point = point;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
