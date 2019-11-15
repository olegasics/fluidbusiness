package ru.basics.server.repository.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFountException extends RuntimeException {

    public EntityNotFountException(Long id) {
        super("Entity with id=" + id + " not found");
    }

    public EntityNotFountException(String name) {
        super("Entity with name=" + name + " not found");
    }
}
