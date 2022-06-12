package com.example.practice.helpers;

public enum OrderBy {
    ID("id"),
    BOOK_NAME("name"),
    BOOK_PRICE("price"),
    AUTHOR_SURNAME("surname");

    String column;

    OrderBy(String column) {
        this.column = column;
    }

    public String getColumn() {
        return column;
    }
}
