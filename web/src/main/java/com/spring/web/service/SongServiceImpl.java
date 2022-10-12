package com.spring.web.service;

import com.spring.web.domain.Song;
import com.spring.web.entity.SongEntity;
import com.spring.web.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "songService")
public class SongServiceImpl implements SongService{

    private SongRepository songRepository;

    @Autowired
    public void setSongRepository(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Song addSong(Song song) {
        // TODO
        SongEntity songEntity = new SongEntity(
                song.getTitle(), song.getSinger(), song.getComposer(), song.getYear());

        songRepository.save(songEntity);
        return song;
    }
}
