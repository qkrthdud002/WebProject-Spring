package com.subject.board.boardsubject.security;

import com.subject.board.boardsubject.member.Role;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegistryRequest {

    private String userId;

    private String password;

    private String username;

    private Role role = Role.ROLE_MEMBER;
}
