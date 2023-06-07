package org.aJohnson.java_web_final_project.service;


import org.aJohnson.java_web_final_project.model.Song;
import org.aJohnson.java_web_final_project.model.SongDto;
import org.aJohnson.java_web_final_project.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepo){
        songRepository = songRepo;
    }

    //C.R.U.D. methods

    //Create
    public void addSong(SongDto newSong){
        Song songToAdd = new Song();

        songToAdd.setSongName(newSong.songName());
        songToAdd.setSongLength(newSong.songLength());

        songRepository.save(songToAdd);
    }

    //Read
    public List<Song> getAllSongs(){
        return songRepository.findAll();
    }

    public Optional<Song> findSongById(Integer songId){
        return songRepository.findById(songId);
    }


    //Update
    public void putSong(Song song) {
        Integer id = song.getId();
        Song foundSong = songRepository.findById(id).orElseThrow();
        foundSong.setSongName(song.getSongName());
        foundSong.setSongLength(song.getSongLength());
        songRepository.save(foundSong);
    }

    public void putSong(SongDto song, Integer id){
        Song foundSong = songRepository.findById(id).orElseThrow();
        foundSong.setSongName(song.songName());
        foundSong.setSongLength(song.songLength());
        songRepository.save(foundSong);
    }


    //Delete
    public void deleteById(Integer songId){
        songRepository.deleteById(songId);
    }

}
