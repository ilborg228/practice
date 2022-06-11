package com.example.practice.controller;

import com.example.practice.dto.AuthorDto;
import com.example.practice.entity.Author;
import com.example.practice.helpers.OrderBy;
import com.example.practice.helpers.OrderByType;
import com.example.practice.repository.AuthorRepository;
import com.example.practice.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController extends BaseController{

    private final AuthorService authorService;

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public Author add(@RequestBody AuthorDto authorDto) {
        return authorService.add(authorDto);
    }

    @GetMapping("/authors")
    public List<AuthorDto> get(
            @RequestParam(required = false, defaultValue = DEF_PARAM_PAGE) Integer page,
            @RequestParam(required = false, name = PAGE_SIZE, defaultValue = DEF_PARAM_PAGE_SIZE) Integer pageSize,
            @RequestParam(required = false, name = ORDER_BY) OrderBy orderBy,
            @RequestParam(required = false, name = ORDER_BY_TYPE, defaultValue = DEF_PARAM_ORDER_BY_TYPE) OrderByType orderByType){
        return authorService.getAuthors(page, pageSize, orderBy, orderByType);
    }

    @DeleteMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        authorService.delete(id);
    }
}
