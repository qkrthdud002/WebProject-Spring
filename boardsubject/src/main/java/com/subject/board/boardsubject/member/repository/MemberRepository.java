package com.subject.board.boardsubject.member.repository;

import com.subject.board.boardsubject.member.dto.MemberInsertDTO;
import com.subject.board.boardsubject.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    boolean existsById(String id);
    MemberEntity findById(String id);

}
