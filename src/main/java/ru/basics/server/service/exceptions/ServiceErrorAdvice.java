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

    Logger logger = Logger.getLogger("test12");

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({RuntimeException.class})
    public void handle(String s) {
        logger.info("testing");
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
