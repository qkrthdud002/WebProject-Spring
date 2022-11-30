package com.subject.board.boardsubject.member;

import lombok.Getter;

@Getter
public enum Role {

    ROLE_ADMIN("관리자"), ROLE_MANAGER("매니저"), ROLE_MEMBER("일반 사용자");

    private String description;

    Role(String description) {
        this.description = description;
    }

}
