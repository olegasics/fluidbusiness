package ru.basics.server.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.basics.server.repository.exceptions.BadRequestException;
import ru.basics.server.repository.exceptions.EntityNotFoundException;

import java.sql.SQLException;
import java.util.logging.Logger;

@ControllerAdvice
public class ServiceErrorAdvice {

    Logger logger = Logger.getLogger("Тут должен быть класс");


    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<EntityNotFoundException> handle(EntityNotFoundException e) {
        logger.info("EntityNotFountException");
        return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({SQLException.class, NullPointerException.class})
    public void handle(Exception e) {
    }


    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<BadRequestException> handle(BadRequestException e) {
        logger.info("BadRequestExceprion");
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }
}
