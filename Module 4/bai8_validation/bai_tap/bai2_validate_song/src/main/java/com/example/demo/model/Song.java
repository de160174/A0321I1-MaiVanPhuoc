package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSong;

    @NotBlank(message = "không được trống")
    @Pattern(regexp = "^[a-zA-Z0-9]*$",message = "không chứa ký tự đặc biệt")
    private String nameSong;

    @NotBlank(message = "không được trống")
    @Size(max = 300,message = "{errorSize}")
    @Pattern(regexp = "^[a-zA-Z0-9]*$",message = "không chứa ký tự đặc biệt")
    private String singer;

    @NotBlank(message = "không được trống")
    @Size(max = 1000,message = "{errorSize}")
    @Pattern(regexp = "^[a-zA-Z0-9 ,]*$",message = "không chứa ký tự đặc biệt ngoại trừ dấu phẩy")
    private String categorySong;

    public Song() {
    }

    public int getIdSong() {
        return idSong;
    }

    public void setIdSong(int idSong) {
        this.idSong = idSong;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategorySong() {
        return categorySong;
    }

    public void setCategorySong(String categorySong) {
        this.categorySong = categorySong;
    }
}
