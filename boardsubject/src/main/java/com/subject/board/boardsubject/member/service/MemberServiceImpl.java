package com.subject.board.boardsubject.member.service;

import com.subject.board.boardsubject.member.dto.MemberInsertDTO;
import com.subject.board.boardsubject.member.dto.MemberLoginDTO;
import com.subject.board.boardsubject.member.entity.MemberEntity;
import com.subject.board.boardsubject.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public MemberEntity insert(MemberInsertDTO memberInsertDTO) {

        if(memberRepository.existsById(memberInsertDTO.getId())) {
            throw new RuntimeException("이미 존재하는 아이디입니다.");
        }

        MemberEntity memberEntity = MemberEntity.builder()
                .id(memberInsertDTO.getId())
                .password(memberInsertDTO.getPassword())
                .username(memberInsertDTO.getUsername())
                .build();

        return memberEntity;
    }

    @Override
    public MemberEntity login(MemberLoginDTO memberLoginDTO) {
        MemberEntity memberEntity = memberRepository.findById(memberLoginDTO.getId());

        if(memberEntity.getPassword().equals(memberLoginDTO.getPassword())) {
            throw new RuntimeException("아이디 또는 비밀번호가 올바르지 않습니다.");
        }

        return memberEntity;
    }

}
