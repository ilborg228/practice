package com.example.practice.dto;

import lombok.Data;

import java.util.List;

@Data
public class GenreDto {
    private Long id;
    private String name;
    private List<BookDto> books;
}
