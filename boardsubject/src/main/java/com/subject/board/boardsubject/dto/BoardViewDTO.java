package com.subject.board.boardsubject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class BoardViewDTO {

    private Long id;

    private String username;

    private String title;

    private String content;

    private String createdTime;

    private int views;

}
