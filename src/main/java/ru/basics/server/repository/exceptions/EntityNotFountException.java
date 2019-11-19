package ru.basics.server.repository.exceptions;

public class EntityNotFountException extends RuntimeException {

    public EntityNotFountException(Long id) {
        super("Entity with id=" + id + " not found");
    }

    public EntityNotFountException(String name) {
        super("Entity with name=" + name + " not found");
    }
}
