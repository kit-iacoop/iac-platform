package com.domain.noticeBoard;

import com.domain.account.Account;
import com.domain.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "NOTICE_BOARD")
public class NoticeBoard extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOTICE_BOARD_ID", nullable = false)
    private Long noticeBoardContentId;

    @Column(name = "NOTICE_BOARD_TITLE", nullable = false)
    private String noticeBoardContentTitle;

    @Column(name = "NOTICE_BOARD_CONTENT", nullable = false)
    private String noticeBoardContentContent;

    @ManyToOne
    @JoinColumn(name = "AUTHOR", nullable = false)
    private Account account;

    public void setAccount(Account account) {
        if (this.account != null) {
            this.account.getBoardContents().remove(this);
        }
        this.account = account;
        account.getBoardContents().add(this);
    }
}
