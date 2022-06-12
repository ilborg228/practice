package com.example.practice.exceptions;

import org.springframework.http.HttpStatus;

public class DataValidationResponse extends AbstractResponse {

    private static final HttpStatus BAD_STATUS = HttpStatus.BAD_REQUEST;
    static final int MIN_CODE = 1000;
    static final int MAX_CODE = 1999;

    public static final DataValidationResponse GENRE_ALREADY_EXIST =
            new DataValidationResponse(1000,"Genre already exists");
    public static final DataValidationResponse BOOK_ALREADY_EXIST =
            new DataValidationResponse(1001,"Book already exists");
    public static final DataValidationResponse AUTHOR_ALREADY_EXIST =
            new DataValidationResponse(1002,"Author already exists");
    public static final DataValidationResponse INVALID_REQUEST =
            new DataValidationResponse(1003,"Invalid request");

    DataValidationResponse(int code, String error) {
        super(code, error, BAD_STATUS);
    }

    DataValidationResponse(int code, int oldCode, String error) {
        super(code, oldCode, error, BAD_STATUS);
    }

    DataValidationResponse(int code, String error, HttpStatus status) {
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
