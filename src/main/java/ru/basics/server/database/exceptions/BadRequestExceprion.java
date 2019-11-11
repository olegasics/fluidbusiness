package ru.basics.server.database.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestExceprion extends RuntimeException {

    public BadRequestExceprion(Long id) {
        super("Bad request with " + id);
    }

    public BadRequestExceprion(String name) {
        super("Bad request with" + name);
    }

    public BadRequestExceprion(Object o) {

        super("Bad request with" + o);
    }
}
