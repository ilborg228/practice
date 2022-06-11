package com.example.practice.exceptions;

import org.springframework.http.HttpStatus;

public class DataNotFoundResponse extends AbstractResponse{
    private static final HttpStatus BAD_STATUS = HttpStatus.BAD_REQUEST;
    static final int MIN_CODE = 2000;
    static final int MAX_CODE = 2999;

    public static final DataNotFoundResponse GENRE_NOT_FOUND =
            new DataNotFoundResponse(2000,"Genre not found");

    public static final DataNotFoundResponse BOOK_NOT_FOUND =
            new DataNotFoundResponse(2001,"Book not found");

    public static final DataNotFoundResponse AUTHOR_NOT_FOUND =
            new DataNotFoundResponse(2001,"Author not found");

    DataNotFoundResponse(int code, String error) {
        super(code, error, BAD_STATUS);
    }

    DataNotFoundResponse(int code, int oldCode, String error) {
        super(code, oldCode, error, BAD_STATUS);
    }

    DataNotFoundResponse(int code, String error, HttpStatus status) {
        super(code, error, status);
    }

    @Override
    public AbstractResponse withDescription(String description) {
        AbstractResponse code = new DataValidationResponse(this.code, this.error);
        code.status = this.status;
        code.description = description;
        code.oldCode = this.oldCode;
        return code;
    }

    @Override
    public AbstractResponse withStatus(HttpStatus status) {
        AbstractResponse code = new DataValidationResponse(this.code, this.error);
        code.status = status;
        code.description = this.description;
        code.oldCode = this.oldCode;
        return code;
    }

    @Override
    public AbstractResponse withError(String error) {
        AbstractResponse code = new DataValidationResponse(this.code, error);
        code.status = this.status;
        code.description = this.description;
        code.oldCode = this.oldCode;
        return code;
    }
}
