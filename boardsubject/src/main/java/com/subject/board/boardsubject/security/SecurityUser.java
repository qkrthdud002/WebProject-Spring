package com.subject.board.boardsubject.security;

import com.subject.board.boardsubject.member.entity.MemberEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Slf4j
@Getter @Setter
public class SecurityUser extends User {

    private MemberEntity member;

    public SecurityUser(MemberEntity member) {
        super(member.getId(), member.getPassword(), AuthorityUtils.createAuthorityList(member.getRole().toString()));

        log.info("SecurityUser member.username = {}", member.getUsername());
        log.info("SecurityUser member.username = {}", member.getPassword());
        log.info("SecurityUser member.username = {}", member.getRole().toString());

        this.member = member;
    }

}
