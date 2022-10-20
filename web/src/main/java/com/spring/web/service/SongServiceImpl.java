package com.spring.web.service;

import com.spring.web.domain.Artist;
import com.spring.web.domain.Song;
import com.spring.web.entity.ArtistEntity;
import com.spring.web.entity.SongEntity;
import com.spring.web.repository.ArtistRepository;
import com.spring.web.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value = "songService")
public class SongServiceImpl implements SongService{

    private SongRepository songRepository;

    private ArtistRepository artistRepository;

    @Autowired
    public void setSongRepository(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Autowired
    public void setArtistRepository(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @PostConstruct
    public void prepare() {

        ArtistEntity artist = new ArtistEntity();
        artist.setName("BTS");
        artist.setDebutYear(2013);
        artistRepository.save(artist);

        SongEntity song = new SongEntity();
        song.setTitle("다이너마이트");
        song.setYear(2020);
        song.setComposer("미국사람");
        song.setArtist(artist);
        songRepository.save(song);

        artist = new ArtistEntity();
        artist.setName("BlackPink");
        artist.setDebutYear(2017);
        artistRepository.save(artist);

        artist = new ArtistEntity();
        artist.setName("아이유");
        artist.setDebutYear(2005);
        artistRepository.save(artist);

    }

    @Override
    public Song addSong(Song song) {
        // TODO
//        SongEntity songEntity = new SongEntity(song.getIdx(), song.getTitle(), song.getComposer(), song.getYear());

        SongEntity songEntity = new SongEntity();
        songEntity.setTitle(song.getTitle());
        songEntity.setComposer(song.getComposer());
        songEntity.setYear(song.getYear());

        songRepository.save(songEntity);
        return song;
    }

    @Override
    public List<Song> getList() {
        List<SongEntity> list = songRepository.findAll();

        List<Song> result = new ArrayList<>();
        for(SongEntity item : list) {
            Song song = new Song(item.getTitle(),
                    item.getComposer(), item.getYear());
            song.setIdx(item.getIdx());

            result.add(song);

        }

        return result;
    }

    @Override
    public Song read(Long idx) {
        Optional<SongEntity> optional = songRepository.findById(idx);

        if(optional.isPresent()) {
            SongEntity entity = optional.get();
            Song song = new Song(entity.getTitle(),
                    entity.getComposer(), entity.getYear());

            Artist artist = new Artist();
            artist.setArtistIdx(artist.getArtistIdx());
            artist.setName(artist.getName());
            artist.setDebutYear(artist.getDebutYear());

            song.setIdx(entity.getIdx());

            return song;

        } else {
            throw new IllegalArgumentException("잘못된 idx 입니다.");
        }
    }

    @Override
    public void update(Song song) {
        SongEntity entity = new SongEntity(song.getIdx(), song.getTitle(),
                song.getComposer(), song.getYear());

        songRepository.save(entity);
    }

    @Override
    public void delete(Long idx) {
        songRepository.deleteById(idx);
    }

}
