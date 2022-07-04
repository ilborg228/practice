package com.example.practice.service;

import com.example.practice.exceptions.ApiException;
import com.example.practice.exceptions.DataValidationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {

    @Autowired
    protected RabbitTemplate rabbitTemplate;
    @Autowired
    protected ObjectMapper jsonMapper;

    public static final String NEW_BOOK_MESSAGE = "New book was created";
    public static final String NEW_GENRE_MESSAGE = "New genre was created";

    protected void notNull(Object o) {
        if(o == null)
            throw new ApiException(DataValidationResponse.INVALID_REQUEST);
    }
}
