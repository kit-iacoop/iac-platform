package com.domain.noticeBoard;

import com.web.dto.NoticeBoardDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface NoticeBoardRepository extends JpaRepository<NoticeBoard, Long> {
    Page<NoticeBoard> findAllByNoticeBoardTitleContains(Pageable pageable, String key);

    @Query("select new com.web.dto.NoticeBoardDTO(b.noticeBoardId,b.noticeBoardTitle) from NoticeBoard b where b.noticeBoardId > :id order by b.noticeBoardId asc")
    Page<NoticeBoardDTO> findNextBoardId(Long id, Pageable pageable);

    @Query("select new com.web.dto.NoticeBoardDTO(b.noticeBoardId,b.noticeBoardTitle) from NoticeBoard b where b.noticeBoardId < :id order by b.noticeBoardId desc")
    Page<NoticeBoardDTO> findPrevBoardId(Long id, Pageable pageable);
}
