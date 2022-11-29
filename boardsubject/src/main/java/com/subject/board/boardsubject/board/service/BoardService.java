package com.subject.board.boardsubject.board.service;

import com.subject.board.boardsubject.board.domain.Board;
import com.subject.board.boardsubject.board.dto.*;
import com.subject.board.boardsubject.board.entity.BoardEntity;

import java.util.List;

public interface BoardService {
    /**
     * 등록된 게시글 목록을 가져온다.
     * */
    public List<BoardListDTO> getList();

    /**
     * 새 게시글을 등록한다.
     */
    public Board addBoard(Board board);

    /**
     * 주어진 id를 가진 게시글을 가져온다.
     */
    public BoardViewDTO read(Long id);
    public BoardEntity insert(BoardInsertDTO boardInsertDTO);

    /**
     * 게시글을 수정한다.
     */
    public BoardEntity update(Board boardUpdateDTO);

    /**
     * 수정한 게시글을 가져온다.
     */
    public BoardUpdateDTO updateView(Long id);

    /**
     * 게시글을 삭제한다.
     */
    public Long delete(BoardDeleteDTO boardDeleteDTO);
}
