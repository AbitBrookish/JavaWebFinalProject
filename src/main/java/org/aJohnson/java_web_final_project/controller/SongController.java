package org.aJohnson.java_web_final_project.controller;


import org.aJohnson.java_web_final_project.model.Song;
import org.aJohnson.java_web_final_project.service.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/")
public class SongController {

    private final SongService songService;

    private SongController(SongService songServ){
        songService = songServ;
    }

    @GetMapping
    public List<Song> getAllSongs(){
        return songService.findAllSongs();
    }

    @GetMapping("/{id}")
    public Optional<Song> getSongById(@PathVariable Integer id){
        return songService.findSongById(id);
    }

    @PostMapping
    public void saveNewSong(@RequestBody Song song){
        songService.save(song);
    }

    @PutMapping
    public void updateSong(@RequestBody Song song){
        songService.updateSong(song);
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable(name="id") Integer id){
        songService.deleteById(id);
    }
}
