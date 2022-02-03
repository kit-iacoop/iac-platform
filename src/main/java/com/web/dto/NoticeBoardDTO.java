package com.web.dto;

import com.domain.noticeBoard.NoticeBoard;
import com.web.dto.account.AccountInformationDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NoticeBoardDTO {
    private String noticeBoardId;
    private String noticeBoardTitle;
    private String noticeBoardContent;
    private String noticeBoardDate; // 생성일

    // 작성자
    private String accountId;
    private String accountName;
    private String accountRole;

    public NoticeBoardDTO(NoticeBoard noticeBoard) {
        this.noticeBoardId = String.valueOf(noticeBoard.getNoticeBoardId());
        this.noticeBoardTitle = noticeBoard.getNoticeBoardTitle();
        this.noticeBoardContent = noticeBoard.getNoticeBoardContent();
        this.noticeBoardDate = noticeBoard.getCreatedDate().toString();
        this.accountId = String.valueOf(noticeBoard.getAccount().getAccountId());
        this.accountName = noticeBoard.getAccount().getName();
    }

    public NoticeBoard toEntity() {
        // 작성자 정보는 서비스에서 가져오도록 한다.
        return NoticeBoard.builder()
                .noticeBoardId(Long.valueOf(this.noticeBoardId))
                .noticeBoardTitle(this.noticeBoardTitle)
                .noticeBoardContent(this.noticeBoardContent)
                .build();
    }
}
