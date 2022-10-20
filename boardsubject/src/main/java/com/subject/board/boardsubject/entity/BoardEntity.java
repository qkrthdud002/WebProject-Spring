package com.subject.board.boardsubject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(length = 50)
    private String username;

    @Column(length = 100)
    private String title;

    @Column(length = 1000)
    private String content;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(nullable = false)
    private LocalDateTime createdTime;

    private Long count;

    @Builder
    public BoardEntity(String username, String title, String content, LocalDateTime createdTime, Long count) {
        this.username = username;
        this.title = title;
        this.content = content;
        this.createdTime = createdTime;
        this.count = count;
    }



}
