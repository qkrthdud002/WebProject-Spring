package com.subject.board.boardsubject.member.entity;

import com.subject.board.boardsubject.member.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long idx;

    private String id;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

}
