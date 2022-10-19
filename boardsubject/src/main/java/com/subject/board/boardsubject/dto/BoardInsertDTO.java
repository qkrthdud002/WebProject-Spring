package com.subject.board.boardsubject.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BoardInsertDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private LocalDateTime createdTime;

}
