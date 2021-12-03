package com.example.demo.validator;

import com.example.demo.model.Song;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SongValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Song.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Song song=(Song)target;
        if (song.getNameSong().length()<2|song.getNameSong().length()>800){
            errors.rejectValue("nameSong","error.Size",new String[]{"2","800"},"độ dài sai");
        }
    }
}
