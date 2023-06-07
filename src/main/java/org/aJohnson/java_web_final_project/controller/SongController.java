package org.aJohnson.java_web_final_project.controller;

import org.aJohnson.java_web_final_project.model.Song;
import org.aJohnson.java_web_final_project.model.SongDto;
import org.aJohnson.java_web_final_project.service.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/song")
public class SongController {

    private final SongService songService;

    public SongController(SongService songServ){
        songService = songServ;
    }

    @GetMapping
    public List<Song> getAllSongs(){
        return songService.getAllSongs();
    }

    @GetMapping("/{id}")
    public Optional<Song> getSongById(@PathVariable Integer id){
        return songService.findSongById(id);
    }

    @PostMapping
    public void saveNewSong(@RequestBody SongDto song){
        songService.addSong(song);
    }


    @PutMapping("/{id}")
    public void putSong(@RequestBody SongDto song, @PathVariable Integer id){
        songService.putSong(song,id);
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable(name="id") Integer id){
        songService.deleteById(id);
    }
}
