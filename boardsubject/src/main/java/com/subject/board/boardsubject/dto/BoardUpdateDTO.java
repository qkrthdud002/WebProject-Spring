package com.subject.board.boardsubject.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@Builder
public class BoardUpdateDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String title;

    @NotBlank
    private String content;



}
