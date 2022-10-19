package com.subject.board.boardsubject.repository;

import com.subject.board.boardsubject.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

}
