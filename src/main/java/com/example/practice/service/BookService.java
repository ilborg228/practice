package com.example.practice.service;

import com.example.practice.dto.BookDto;
import com.example.practice.entity.Book;
import com.example.practice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService extends BaseService{

    private final BookRepository bookRepository;


    public Book add(BookDto bookDto) {
        return null;
    }

    public BookDto getById(Long id) {
        return null;
    }

    public void delete(Long id) {

    }
}
