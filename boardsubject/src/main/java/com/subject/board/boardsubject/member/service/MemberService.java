package com.subject.board.boardsubject.member.service;

import com.subject.board.boardsubject.member.dto.MemberInsertDTO;
import com.subject.board.boardsubject.member.dto.MemberLoginDTO;
import com.subject.board.boardsubject.member.entity.MemberEntity;

public interface MemberService {
    public MemberEntity insert(MemberInsertDTO memberInsertDTO);
    public MemberEntity login(MemberLoginDTO memberLoginDTO);
}
