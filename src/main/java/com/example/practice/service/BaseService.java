package com.example.practice.service;

import com.example.practice.exceptions.ApiException;
import com.example.practice.exceptions.DataValidationResponse;

public class BaseService {
    protected void notNull(Object o) {
        if(o == null)
            throw new ApiException(DataValidationResponse.INVALID_REQUEST);
    }
}
