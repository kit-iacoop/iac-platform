package com.web.controller.board;

import com.web.dto.NoticeBoardDTO;
import com.web.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping({"", "/"})
    public String redirectList() {
        return "redirect:/boards/list";
    }

    @GetMapping("/list")
    public String findAllBoard(
            @PageableDefault(sort = "createdDate", direction = Sort.Direction.DESC) Pageable pageable,
            @RequestParam(value = "key", defaultValue = "") String key,
            Model model
    ) {

        Page<NoticeBoardDTO> boardPage = boardService.findAllBoard(pageable, key);

        model.addAttribute("boardDtos", boardPage);
        model.addAttribute("key", key);

        return "board/board-list";
    }

    @GetMapping("/new")
    public String newBoardForm(Model model) {
        model.addAttribute("boardDTO", new NoticeBoardDTO());
        return "board/board-form";
    }

    @PostMapping("/list")
    public String insertNewBoard(@RequestBody @ModelAttribute @Valid NoticeBoardDTO boardDTO) {
        boardService.insertBoard(boardDTO);

        return "redirect:/boards/list";
    }

    @GetMapping("/list/{id}")
    public String viewBoardDetail(@PathVariable Long id, Model model) {
        model.addAttribute("curBoardDTO", boardService.findBoard(id));
        model.addAttribute("prevBoardDTO", boardService.findPrevBoard(id));
        model.addAttribute("nextBoardDTO", boardService.findNextBoard(id));

        return "board/board-detail";
    }

}
