package com.subject.board.boardsubject.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardDeleteDTO {

    @NotNull
    private Long id;

}
