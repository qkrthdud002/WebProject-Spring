package com.subject.board.boardsubject.service;

import com.subject.board.boardsubject.domain.Board;
import com.subject.board.boardsubject.dto.BoardDeleteDTO;
import com.subject.board.boardsubject.dto.BoardInsertDTO;
import com.subject.board.boardsubject.dto.BoardListDTO;
import com.subject.board.boardsubject.dto.BoardViewDTO;
import com.subject.board.boardsubject.entity.BoardEntity;
import com.subject.board.boardsubject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService{

//    private final BoardService boardService;

    private final BoardRepository boardRepository;

    @Override
    public List<BoardListDTO> getList() {
        List<BoardEntity> list = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "createdTime"));

        List<BoardListDTO> result = new ArrayList<>();
        for(BoardEntity item : list) {
            BoardListDTO board = BoardListDTO.builder()
                    .id(item.getId())
                    .username(item.getUsername())
                    .title(item.getTitle())
                    .content(item.getContent())
                    .createdTime(item.getCreatedTime())
                    .views(item.getViews())
                    .build();

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
        boardEntity.setCreatedTime(board.getCreatedTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd a HH:mm")));

        boardRepository.save(boardEntity);
        return board;
    }

    @Override
    public BoardViewDTO read(Long id) {

        Optional<BoardEntity> optional = boardRepository.findById(id);

        if(optional.isPresent()) {
            BoardEntity boardEntity = optional.get();
            boardEntity.addViews();

            BoardViewDTO boardViewDTO = BoardViewDTO.builder()
                    .id(boardEntity.getId())
                    .username(boardEntity.getUsername())
                    .title(boardEntity.getTitle())
                    .content(boardEntity.getContent())
                    .views(boardEntity.getViews())
                    .createdTime(boardEntity.getCreatedTime())
                    .build();

            return boardViewDTO;

        } else {
            throw new IllegalArgumentException("잘못된 id 입니다.");
        }
    }

//    @Override
//    @Transactional
//    public int updateView(Long id) {
//        return boardRepository.updateView(id);
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

        BoardEntity boardEntity = boardRepository.findById(boardUpdateDTO.getId()).orElseThrow(() -> new RuntimeException());

        boardEntity.modify(boardUpdateDTO.getUsername(), boardUpdateDTO.getTitle(), boardUpdateDTO.getContent(), LocalDateTime.now());
        return boardEntity;
    }

    @Override
    public Long delete(BoardDeleteDTO boardDeleteDTO) {

        BoardEntity boardEntity = boardRepository.getReferenceById(boardDeleteDTO.getId());

        boardRepository.delete(boardEntity);
        return boardEntity.getId();
    }
}
