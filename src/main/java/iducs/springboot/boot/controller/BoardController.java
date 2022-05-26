package iducs.springboot.boot.controller;

import iducs.springboot.boot.domain.PageRequestDTO;
import iducs.springboot.boot.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boards")
public class BoardController {
    public final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("")
    public String getBoards(PageRequestDTO pageRequestDTO, Model model) {
        model.addAttribute("list", boardService.getList(pageRequestDTO));
        return "/boards/boards";
    }

}
