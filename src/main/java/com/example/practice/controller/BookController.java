package com.example.practice.controller;

import com.example.practice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController extends BaseController{

    private final BookService bookService;//TODO
}