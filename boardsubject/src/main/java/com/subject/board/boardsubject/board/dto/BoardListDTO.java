package com.subject.board.boardsubject.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class BoardListDTO {

    private Long id;

    private String username;

    private String title;

    private String content;

    private String createdTime;

    private int views;

}
