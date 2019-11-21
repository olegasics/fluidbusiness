package ru.basics.server.repository.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Long id) {
        super("Entity with id=" + id + " not found");
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
