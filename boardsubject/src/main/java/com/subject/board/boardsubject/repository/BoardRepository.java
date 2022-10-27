package com.subject.board.boardsubject.repository;

import com.subject.board.boardsubject.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

//    @Modifying
//    @Transactional
//    @Query(value = "update board b set b.views = b.views + 1 where board_id = :id", nativeQuery = true)
//    int updateView(@Param("id") Long id);
//

}
