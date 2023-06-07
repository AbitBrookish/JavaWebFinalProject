package org.aJohnson.java_web_final_project.repository;

import org.aJohnson.java_web_final_project.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Integer> {
}
