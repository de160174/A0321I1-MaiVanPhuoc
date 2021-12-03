package com.example.demo.service;

import com.example.demo.model.Song;

import java.util.List;

public interface SongService {
    List<Song> findAll();

    Song findById(int id);

    void save(Song song);

}
