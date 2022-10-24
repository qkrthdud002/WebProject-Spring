package com.subject.board.boardsubject.service;

import com.subject.board.boardsubject.domain.Board;
import com.subject.board.boardsubject.dto.BoardDeleteDTO;
import com.subject.board.boardsubject.dto.BoardInsertDTO;
import com.subject.board.boardsubject.entity.BoardEntity;
import com.subject.board.boardsubject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Override
    public List<Board> getList() {
        List<BoardEntity> list = boardRepository.findAll();

        List<Board> result = new ArrayList<>();
        for(BoardEntity item : list) {
            Board board = new Board(item.getUsername(),
                    item.getTitle(),
                    item.getContent()
                    //item.getCreatedTime(),
                    //item.getCount()
            );
            board.setId(item.getId());

            result.add(board);
        }

        return result;
    }

    @Override
    public Board addBoard(Board board) {

//        BoardEntity boardEntity = new BoardEntity(board.getUsername(), board.getTitle(), board.getContent(), board.getCreatedTime(), board.getCount());

        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setUsername(board.getUsername());
        boardEntity.setTitle(board.getTitle());
        boardEntity.setContent(board.getContent());
        boardEntity.setCreatedTime(board.getCreatedTime());

        boardRepository.save(boardEntity);
        return board;
    }

    @Override
    public Board read(Long id) {

        Optional<BoardEntity> optional = boardRepository.findById(id);

        if(optional.isPresent()) {
            BoardEntity boardEntity = optional.get();
            Board board = new Board(boardEntity.getUsername(), boardEntity.getTitle(), boardEntity.getContent());

            board.setId(boardEntity.getId());

            return board;

        } else {
            throw new IllegalArgumentException("잘못된 id 입니다.");
        }
    }

//    @Override
//    public int updateView(Long id) {
//
//
//
//        return 0;
//    }

    @Override
    public BoardEntity insert(BoardInsertDTO boardInsertDTO) {

        BoardEntity boardEntity = BoardEntity.builder()
                .username(boardInsertDTO.getUsername())
                .title(boardInsertDTO.getTitle())
                .content(boardInsertDTO.getContent())
                .build();

        return boardRepository.save(boardEntity);
    }

    @Override
    public BoardEntity update(Board boardUpdateDTO) {

        BoardEntity boardEntity = BoardEntity.builder()
                .username(boardUpdateDTO.getUsername())
                .title(boardUpdateDTO.getTitle())
                .content(boardUpdateDTO.getContent())
                .build();

        return boardRepository.save(boardEntity);
    }

    @Override
    public void delete(BoardDeleteDTO boardDeleteDTO) {

        BoardEntity boardEntity = boardRepository.getReferenceById(boardDeleteDTO.getId());

        boardRepository.delete(boardEntity);

    }
}
