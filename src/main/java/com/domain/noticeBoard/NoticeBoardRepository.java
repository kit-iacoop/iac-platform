package com.domain.noticeBoard;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeBoardRepository extends JpaRepository<NoticeBoard, Long> {
    Page<NoticeBoard> findAllByNoticeBoardTitleContains(Pageable pageable, String key);
}
