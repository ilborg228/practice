package com.example.practice.controller;

import com.example.practice.dto.BookDto;
import com.example.practice.entity.Book;
import com.example.practice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookController extends BaseController{

    private final BookService bookService;//TODO

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book add(@RequestBody BookDto bookDto){
        return bookService.add(bookDto);
    }

    @GetMapping("/books/{id}")
    public BookDto getBookDetails(@PathVariable Long id){
        return bookService.getById(id);
    }

    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        bookService.delete(id);
    }
}
