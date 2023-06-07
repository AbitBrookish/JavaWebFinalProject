package org.aJohnson.java_web_final_project.service;


import org.aJohnson.java_web_final_project.model.Song;
import org.aJohnson.java_web_final_project.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private final SongRepository songRepository;

    private SongService(SongRepository songRepo){
        songRepository = songRepo;
    }

    //C.R.U.D. methods

    //Create
    public void save(Song song){
        songRepository.save(song);
    }

    //Read
    public List<Song> findAllSongs(){
        return songRepository.findAll();
    }

    public Optional<Song> findSongById(Integer songId){
        return songRepository.findById(songId);
    }


    //Update
    public void updateSong(Song song){
        Integer id = song.getId();
        songRepository.deleteById(id);
        songRepository.save(song);
    }


    //Delete
    public void deleteById(Integer songId){
        songRepository.deleteById(songId);
    }

}
