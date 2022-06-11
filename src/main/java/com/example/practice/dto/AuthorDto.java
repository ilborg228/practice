package com.example.practice.dto;

import com.example.practice.entity.Book;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AuthorDto {
    private Long id;
    private String firstname;
    private String surname;
    private List<BookDto> books;
}
