package com.example.practice.controller;

import com.example.practice.dto.AuthorDto;
import com.example.practice.dto.BookDto;
import com.example.practice.entity.Book;
import com.example.practice.helpers.OrderBy;
import com.example.practice.helpers.OrderByType;
import com.example.practice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController extends BaseController{

    private final BookService bookService;

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book add(@RequestBody BookDto book){
        return bookService.add(book);
    }

    @GetMapping("/books/{id}")
    public BookDto getBookDetails(@PathVariable Long id){
        return bookService.getById(id);
    }

    @GetMapping("/books")
    public List<BookDto> getAll(
            @RequestParam(required = false, defaultValue = DEF_PARAM_PAGE) Integer page,
            @RequestParam(required = false, name = PAGE_SIZE, defaultValue = DEF_PARAM_PAGE_SIZE) Integer pageSize,
            @RequestParam(required = false, name = ORDER_BY, defaultValue = DEF_PARAM_ORDER_BY) OrderBy orderBy,
            @RequestParam(required = false, name = ORDER_BY_TYPE, defaultValue = DEF_PARAM_ORDER_BY_TYPE) OrderByType orderByType){
        return bookService.getAll(page, pageSize, orderBy, orderByType);
    }

    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        bookService.delete(id);
    }

    @PutMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody BookDto req){
        bookService.update(id,req);
    }
}
