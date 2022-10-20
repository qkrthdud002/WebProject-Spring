package com.subject.board.boardsubject.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Board {

    private Long id;

    private String username;

    private String title;

    private String content;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdTime;

    public String time;

    private Long count;

    public Board(String username, String title, String content) {
        this.username = username;
        this.title = title;
        this.content = content;
        this.createdTime = LocalDateTime.now();
        this.time = createdTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd a HH:mm"));
        //this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }


    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
