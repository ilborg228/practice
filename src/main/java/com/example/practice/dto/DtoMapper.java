package com.example.practice.dto;

import com.example.practice.entity.Author;
import com.example.practice.entity.Book;
import com.example.practice.entity.Genre;

public class DtoMapper {

    public static Author toAuthorEntity(AuthorDto authorDto){
        Author author = new Author();
        author.setFirstname(author.getFirstname());
        author.setSurname(author.getSurname());
        author.setId(author.getId());
        return author;
    }

    public static AuthorDto toAuthorDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(authorDto.getId());
        authorDto.setFirstname(authorDto.getFirstname());
        authorDto.setSurname(authorDto.getSurname());
        return authorDto;
    }

    public static BookDto toBookDto(Book book){
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setDescription(book.getDescription());
        bookDto.setName(book.getName());
        bookDto.setPrice(book.getPrice());

        bookDto.setAuthorId(book.getAuthor().getId());
        bookDto.setAuthorFirstname(book.getAuthor().getFirstname());
        bookDto.setAuthorSurname(book.getAuthor().getSurname());

        bookDto.setGenreId(book.getGenre().getId());
        bookDto.setGenreName(book.getGenre().getName());
        return bookDto;
    }

    public static Book toBookEntity(BookDto bookDto){
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setName(bookDto.getName());
        book.setDescription(bookDto.getDescription());
        book.setPrice(bookDto.getPrice());

        Author author = new Author();
        author.setId(bookDto.getAuthorId());
        book.setAuthor(author);

        Genre genre = new Genre();
        genre.setId(bookDto.getGenreId());
        book.setGenre(genre);
        return book;
    }
}
