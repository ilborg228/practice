package com.example.practice.controller;

import com.example.practice.dto.GenreDto;
import com.example.practice.entity.Genre;
import com.example.practice.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class GenreController extends BaseController{

    private final GenreService genreService;

    @PostMapping("/genres")
    @ResponseStatus(HttpStatus.CREATED)
    public Genre add(GenreDto genre) {
        return genreService.add(genre);
    }

    @GetMapping("/genres/{id}")
    public GenreDto getById(@PathVariable Long id){
        return genreService.getById(id);
    }
}
