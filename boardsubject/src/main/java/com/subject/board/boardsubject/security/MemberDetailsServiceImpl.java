package com.subject.board.boardsubject.security;

import com.subject.board.boardsubject.member.entity.MemberEntity;
import com.subject.board.boardsubject.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberDetailsServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        MemberEntity findMember = memberRepository.findById(id);
        if(findMember.getId() == null) throw new UsernameNotFoundException("존재하지 않는 userId 입니다.");

        log.info("loadUserByUsername member.id = {}", id);

        return new SecurityUser(findMember);
    }
}
