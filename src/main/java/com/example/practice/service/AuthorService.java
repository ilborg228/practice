package com.example.practice.service;

import com.example.practice.dto.AuthorDto;
import com.example.practice.dto.DtoMapper;
import com.example.practice.entity.Author;
import com.example.practice.exceptions.ApiException;
import com.example.practice.exceptions.DataNotFoundResponse;
import com.example.practice.exceptions.DataValidationResponse;
import com.example.practice.helpers.OrderBy;
import com.example.practice.helpers.OrderByType;
import com.example.practice.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService extends BaseService {

    private final AuthorRepository authorRepository;

    public Author add(AuthorDto author) {
        notNull(author);
        if(authorRepository
                .findAuthorByFirstnameAndSurname(
                        author.getFirstname(), author.getSurname())
                .isPresent()){
            throw new ApiException(DataValidationResponse.AUTHOR_ALREADY_EXIST);
        }

        return authorRepository.save(DtoMapper.toAuthorEntity(author));
    }

    public List<AuthorDto> getAuthors(Integer page, Integer pageSize, OrderBy orderBy, OrderByType orderByType) {
        Sort sort = Sort.by(Sort.Direction.fromString(orderByType.getDirection()),orderBy.getColumn());
        Pageable pageable = PageRequest.of(page,pageSize,sort);
        Page<Author> authors = authorRepository.findAll(pageable);
        return authors.map(DtoMapper::toAuthorDto).getContent();
    }

    public void delete(Long id) {
        if(authorRepository.findById(id).isPresent()){
            authorRepository.deleteById(id);
        }else{
            throw new ApiException(DataNotFoundResponse.AUTHOR_NOT_FOUND);
        }
    }
}
