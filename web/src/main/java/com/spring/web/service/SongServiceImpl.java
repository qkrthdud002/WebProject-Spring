package com.spring.web.service;

import com.spring.web.domain.Song;
import com.spring.web.entity.SongEntity;
import com.spring.web.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        SongEntity songEntity = new SongEntity( song.getIdx(),
                song.getTitle(), song.getSinger(), song.getComposer(), song.getYear());

        songRepository.save(songEntity);
        return song;
    }

    @Override
    public List<Song> getList() {
        List<SongEntity> list = songRepository.findAll();

        List<Song> result = new ArrayList<>();
        for(SongEntity item : list) {
            Song song = new Song(item.getTitle(), item.getSinger(),
                    item.getComposer(), item.getYear());
            song.setIdx(item.getIdx());

            result.add(song);

        }

        return null;
    }

    @Override
    public Song read(Long idx) {
        Optional<SongEntity> optional = songRepository.findById(idx);

        if(optional.isPresent()) {
            SongEntity entity = optional.get();
            Song song = new Song(entity.getTitle(), entity.getSinger(),
                    entity.getComposer(), entity.getYear());

            song.setIdx(entity.getIdx());

            return song;

        } else {
            throw new IllegalArgumentException("잘못된 idx 입니다.");
        }
    }

    @Override
    public void update(Song song) {
        SongEntity entity = new SongEntity(song.getIdx(), song.getTitle(), song.getSinger(),
                song.getComposer(), song.getYear());

        songRepository.save(entity);
    }

    @Override
    public void delete(Long idx) {
        songRepository.deleteById(idx);
    }

}
