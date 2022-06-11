package com.example.practice.repository;

import com.example.practice.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    Optional<Author> getAuthorByFirstnameAndSurname(String firstname, String surname);
}
