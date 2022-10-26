package com.subject.board.boardsubject.service;

import com.subject.board.boardsubject.domain.Board;
import com.subject.board.boardsubject.dto.BoardDeleteDTO;
import com.subject.board.boardsubject.dto.BoardInsertDTO;
import com.subject.board.boardsubject.entity.BoardEntity;

import java.util.List;

public interface BoardService {
    public List<Board> getList();
    public Board addBoard(Board board);
    public Board read(Long id);
//    public int updateView(Long id);
    public BoardEntity insert(BoardInsertDTO boardInsertDTO);
    public BoardEntity update(Board boardUpdateDTO);

//    BoardEntity update(BoardUpdateDTO boardUpdateDTO);

    public Long delete(BoardDeleteDTO boardDeleteDTO);
}
