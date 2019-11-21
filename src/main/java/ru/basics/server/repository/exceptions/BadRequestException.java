package ru.basics.server.repository.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class BadRequestException extends RuntimeException {

    public BadRequestException(Long id) {
        super("ERROR: " + id);
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException() {

        super("Неверный запрос");
    }
}
