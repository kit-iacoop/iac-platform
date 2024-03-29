package com.web.service.Impl;

import com.domain.account.AccountRepository;
import com.domain.noticeBoard.NoticeBoard;
import com.domain.noticeBoard.NoticeBoardRepository;
import com.web.dto.NoticeBoardDTO;
import com.web.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @Override
    public NoticeBoardDTO findBoard(Long id) {
        NoticeBoard noticeBoard = noticeBoardRepository.findById(id).orElse(null);
        if (noticeBoard == null) {
            return null;
        }

        return NoticeBoardDTO.builder()
                .noticeBoardId(String.valueOf(noticeBoard.getNoticeBoardId()))
                .noticeBoardTitle(noticeBoard.getNoticeBoardTitle())
                .noticeBoardContent(noticeBoard.getNoticeBoardContent())
                .noticeBoardDate(String.valueOf(noticeBoard.getCreatedDate()))
                .accountId(String.valueOf(noticeBoard.getAccount().getAccountId()))
                .accountName(noticeBoard.getAccount().getName())
                .build();
    }

    @Override
    public NoticeBoardDTO findNextBoard(Long id) {
        Page<NoticeBoardDTO> nextBoardId = noticeBoardRepository.findNextBoardId(id, PageRequest.of(0, 1));
        if (nextBoardId.getTotalElements() == 0) {
            return new NoticeBoardDTO();
        }
        return nextBoardId.toList().get(0);
    }

    @Override
    public NoticeBoardDTO findPrevBoard(Long id) {
        Page<NoticeBoardDTO> prevBoardId = noticeBoardRepository.findPrevBoardId(id, PageRequest.of(0, 1));
        if (prevBoardId.getTotalElements() == 0) {
            return new NoticeBoardDTO();
        }
        return prevBoardId.toList().get(0);
    }


}