package com.example.practice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;

    @OneToMany(mappedBy = "author",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> books;
}
