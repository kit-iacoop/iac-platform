package com.web.dto;

import com.domain.noticeBoard.NoticeBoard;
import com.web.dto.account.AccountInformationDTO;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    public NoticeBoardDTO(Long id, String title) {
        this.noticeBoardId = String.valueOf(id);
        this.noticeBoardTitle = title;
    }

    public NoticeBoard toEntity() {
        // 작성자 정보는 서비스에서 가져오도록 한다.
        // id는 generate 해야한다.
        return NoticeBoard.builder()
                .noticeBoardTitle(this.noticeBoardTitle)
                .noticeBoardContent(this.noticeBoardContent)
                .build();
    }
}
