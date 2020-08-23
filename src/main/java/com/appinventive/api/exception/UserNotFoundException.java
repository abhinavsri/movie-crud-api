package com.appinventive.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -828126129108947213L;

    public UserNotFoundException(String message)
    {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public UserNotFoundException() {

    }
}

