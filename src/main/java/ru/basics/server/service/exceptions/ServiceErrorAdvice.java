package ru.basics.server.service.exceptions;

import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.basics.server.repository.exceptions.BadRequestExceprion;
import ru.basics.server.repository.exceptions.EntityNotFountException;

import java.sql.SQLException;
import java.util.logging.Logger;

@ControllerAdvice
public class ServiceErrorAdvice {

    Logger logger = Logger.getLogger("Тут должен быть класс");


    @ExceptionHandler({EntityNotFountException.class})
    public ResponseEntity<String> handle(EntityNotFountException e) {
        logger.info("testing");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({SQLException.class, NullPointerException.class})
    public void handle(Exception e) {
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BadRequestExceprion.class})
    public void handle(HibernateException e) {
    }
}
