package com.subject.board.boardsubject.board.repository;

import com.subject.board.boardsubject.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

}
