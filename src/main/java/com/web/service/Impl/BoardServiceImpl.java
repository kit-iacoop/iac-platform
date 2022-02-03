package com.web.service.Impl;

import com.domain.account.AccountRepository;
import com.domain.noticeBoard.NoticeBoard;
import com.domain.noticeBoard.NoticeBoardRepository;
import com.web.dto.NoticeBoardDTO;
import com.web.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final NoticeBoardRepository noticeBoardRepository;
    private final AccountRepository accountRepository;

    @Override
    public void insertBoard(NoticeBoardDTO dto) {
        NoticeBoard noticeBoard = dto.toEntity();
        noticeBoard.setAccount(accountRepository.findById(Long.valueOf(dto.getAccountId())).orElse(null));
        if (noticeBoard.getAccount() == null) {
            return;
        }
        noticeBoardRepository.save(noticeBoard);
    }

    @Override
    public Page<NoticeBoardDTO> findAllBoard(Pageable pageable, String key) {
        Page<NoticeBoard> noticeBoardPage = noticeBoardRepository.findAllByNoticeBoardTitleContains(pageable, key);
        return noticeBoardPage.map(NoticeBoardDTO::new);
    }

}