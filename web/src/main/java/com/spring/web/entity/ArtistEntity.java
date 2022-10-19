package com.spring.web.entity;

import javax.persistence.*;

@Entity
@Table(name = "artist")
public class ArtistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int artisttIdx;

    private String name;

    private int debutYear;


    public int getArtisttIdx() {
        return artisttIdx;
    }

    public void setArtisttIdx(int artisttIdx) {
        this.artisttIdx = artisttIdx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDebutYear() {
        return debutYear;
    }

    public void setDebutYear(int debutYear) {
        this.debutYear = debutYear;
    }

}
