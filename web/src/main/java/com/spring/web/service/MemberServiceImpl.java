package com.spring.web.service;

import com.spring.web.domain.Member;
import com.spring.web.entity.MemberEntity;
import com.spring.web.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "memberService")
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member register(Member member) {
        System.out.println("회원 등록 기능 호출됨");
        MemberEntity entity = new MemberEntity();
        entity.setId(member.getId());
        entity.setUsername(member.getUsername());
        entity.setCityName(member.getCityName());

        memberRepository.save(entity);

        return member;
    }
}
