package com.subject.board.boardsubject.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class MemberInsertDTO {

    private String id;

    private String password;

    private String username;

}
