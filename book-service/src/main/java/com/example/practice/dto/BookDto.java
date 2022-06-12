package com.example.practice.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String name;
    private String description;
    private Integer price;

    @JsonProperty("author_id")
    private Long authorId;
    private String authorFirstname;
    private String authorSurname;

    @JsonProperty("genre_id")
    private Long genreId;
    private String genreName;
}
