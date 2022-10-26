package com.subject.board.boardsubject.repository;

import com.subject.board.boardsubject.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

//    @Modifying
//    @Query("update Board b set b.views = b.views + 1 where b.id = :id")
//    int updateView(Long id);

}
