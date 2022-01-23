package com.web.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeetingFileDTO {
    private String meetingFileId;
    private String meetingId;
    private String fileType;
    private String filePath;
    private String fileSize;
}
