package com.subject.board.boardsubject.repository;

import com.subject.board.boardsubject.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

//    @Modifying @Query("update BoardEntity p set p.view = p.view + 1 where p.id = :id")
//    int updateView(Long id);

}
