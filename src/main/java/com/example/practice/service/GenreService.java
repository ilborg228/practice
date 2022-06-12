package com.example.practice.service;

import com.example.practice.dto.DtoMapper;
import com.example.practice.dto.GenreDto;
import com.example.practice.entity.Genre;
import com.example.practice.exceptions.ApiException;
import com.example.practice.exceptions.DataNotFoundResponse;
import com.example.practice.exceptions.DataValidationResponse;
import com.example.practice.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreService extends BaseService{

    private final GenreRepository genreRepository;

    public Genre add(GenreDto genre) {
        notNull(genre);
        if(genreRepository.findGenreByName(genre.getName()).isPresent()){
            throw new ApiException(DataValidationResponse.GENRE_ALREADY_EXIST);
        }

        return genreRepository.save(DtoMapper.toGenreEntity(genre));
    }

    public GenreDto getById(Long id) {
        Optional<Genre> byId = genreRepository.findById(id);
        if(byId.isEmpty()){
            throw new ApiException(DataNotFoundResponse.GENRE_NOT_FOUND);
        }
        return DtoMapper.toGenreDto(byId.get());
    }
}
