package com.subject.board.boardsubject.controller;

import com.subject.board.boardsubject.domain.Board;
import com.subject.board.boardsubject.dto.BoardDeleteDTO;
import com.subject.board.boardsubject.dto.BoardInsertDTO;
import com.subject.board.boardsubject.entity.BoardEntity;
import com.subject.board.boardsubject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;


    @GetMapping("/write")
    public String wrtie() {
        System.out.println("111111111");
        return "/write";
    }

    @PostMapping("/write-list.do")
    public String writeList(
            @RequestParam("username") String username,
            @RequestParam("title") String title,
            @RequestParam("content") String content
            //@RequestParam("createdTime") LocalDateTime createdTime,
            //@RequestParam("count") Long count
    ) {

        Board board = new Board(username, title, content);
        boardService.addBoard(board);

        return "redirect:list";
    }

    @GetMapping("/list")
    public ModelAndView list() {

        ModelAndView mv = new ModelAndView("/list");

        List<Board> list = boardService.getList();
        mv.addObject("list", list);

        return mv;
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("view");

        Board board = boardService.read(id);
        mv.addObject("board", board);

        return mv;
    }

    @GetMapping("/update/{id}")
    public ModelAndView update(
            @PathVariable("id") Long id
    ) {
        ModelAndView mv = new ModelAndView("board/update");

        Board board = boardService.read(id);
        mv.addObject("board", board);

        return mv;
    }

    @RequestMapping("/update-save.do")
    public String updateSave(
            @RequestParam("id") Long id,
            @RequestParam("username") String username,
            @RequestParam("title") String title,
            @RequestParam("content") String content
            //@RequestParam("createdTime") LocalDateTime createdTime,
            //@RequestParam("count") Long count
    ) {
        Board board = new Board(username, title, content);
        board.setId(id);
        boardService.update(board);

        return "redirect:view/" + id;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") BoardDeleteDTO boardDeleteDTO) {
        boardService.delete(boardDeleteDTO);

        return "redirect:/list";
    }

}
