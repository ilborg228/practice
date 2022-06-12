package com.example.practice.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Integer price;

    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;

    @ManyToOne(fetch = FetchType.EAGER)
    private Genre genre;
}
