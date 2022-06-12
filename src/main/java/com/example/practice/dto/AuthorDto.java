package com.example.practice.dto;

import lombok.Data;

import java.util.List;

@Data
public class AuthorDto {
    private Long id;
    private String firstname;
    private String lastname;
    private List<BookDto> books;
}
