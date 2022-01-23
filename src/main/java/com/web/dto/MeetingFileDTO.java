package com.web.dto;

import com.domain.meetingFile.MeetingFile;
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

    public MeetingFileDTO(MeetingFile meetingFile) {
        this.meetingFileId = String.valueOf(meetingFile.getMeetingFileId());
        this.meetingId = String.valueOf(meetingFile.getMeeting().getMeetingId());
        this.fileType = meetingFile.getFileType();
        this.filePath = meetingFile.getFilePath();
        this.fileSize = meetingFile.getFileSize();
    }
}