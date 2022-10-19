package com.spring.web.domain;

public class Artist {

    private Long artistIdx;

    private String name;

    private int debutYear;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDebutYear() {
        return debutYear;
    }

    public void getDebutYear(int debut) {
        this.debutYear = debut;
    }

    public Long getArtistIdx() {
        return artistIdx;
    }

    public void setArtistIdx(Long artistIdx) {
        this.artistIdx = artistIdx;
    }

    public void setDebutYear(int debutYear) {
        this.debutYear = debutYear;
    }
}
