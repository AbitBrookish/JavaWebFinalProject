package org.aJohnson.java_web_final_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


import java.util.Objects;

@Entity
public class Song {

    @Id
    @GeneratedValue
    private Integer id;
    private String artist;
    private String songName;
    private int songLength;

    public Song(){
    }

    public Song(String artist, String title, int timeInMinutes){
        this.artist = artist;
        this.songName = title;
        this.songLength = timeInMinutes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getSongLength() {
        return songLength;
    }

    public void setSongLength(int songLength) {
        this.songLength = songLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song song)) return false;
        return Objects.equals(getId(), song.getId()) && Objects.equals(getArtist(), song.getArtist()) && Objects.equals(getSongName(), song.getSongName()) && Objects.equals(getSongLength(), song.getSongLength());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getArtist(), getSongName(), getSongLength());
    }

    @Override
    public String toString() {
        return "Songs{" +
                "id=" + id +
                ", artist='" + artist + '\'' +
                ", songName='" + songName + '\'' +
                ", songLength=" + songLength +
                '}';
    }
}
