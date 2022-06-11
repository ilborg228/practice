package com.example.practice.service;


import com.example.practice.dto.BookDto;
import com.example.practice.dto.DtoMapper;
import com.example.practice.entity.Book;
import com.example.practice.exceptions.ApiException;
import com.example.practice.exceptions.DataNotFoundResponse;
import com.example.practice.exceptions.DataValidationResponse;
import com.example.practice.helpers.OrderBy;
import com.example.practice.helpers.OrderByType;
import com.example.practice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService extends BaseService {

    private final BookRepository bookRepository;

    public Book add(BookDto book) {
        notNull(book);
        if (bookRepository.findBookByName(book.getName()).isPresent()) {
            throw new ApiException(DataValidationResponse.BOOK_ALREADY_EXIST);
        }

        return bookRepository.save(DtoMapper.toBookEntity(book));
    }

    public BookDto getById(Long id) {
        Optional<Book> byId = bookRepository.findById(id);
        if (byId.isEmpty()) {
            throw new ApiException(DataNotFoundResponse.GENRE_NOT_FOUND);
        }
        return DtoMapper.toBookDto(byId.get());
    }


    public List<BookDto> getAll(Integer page, Integer pageSize, OrderBy orderBy, OrderByType orderByType) {
        Sort sort = Sort.by(Sort.Direction.fromString(orderByType.getDirection()), orderBy.getColumn());
        Pageable pageable = PageRequest.of(page, pageSize, sort);
        Page<Book> books = bookRepository.findAll(pageable);
        return books.map(DtoMapper::toBookDto).getContent();
    }

    public void delete(Long id) {
        if (bookRepository.findById(id).isPresent()) {
            bookRepository.deleteById(id);
        } else {
            throw new ApiException(DataNotFoundResponse.AUTHOR_NOT_FOUND);
        }
    }
}
