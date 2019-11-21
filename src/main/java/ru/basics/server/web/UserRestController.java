package ru.basics.server.web;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.entity.User;
import ru.basics.server.repository.exceptions.EntityNotFoundException;
import ru.basics.server.repository.exceptions.HibernateDBException;
import ru.basics.server.service.AbstractService;
import ru.basics.server.service.UserService;
import ru.basics.server.utils.AuthUtils;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserRestController extends AbstractRestController<User> {
    AuthUtils authUtils;
    UserService userService;

    @Autowired
    public UserRestController(AuthUtils authUtils, UserService userService) {
        this.authUtils = authUtils;
        this.userService = userService;
    }

    public UserRestController() {
    }

    @RequestMapping(value = "/deactivation/{id}", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> deActivation(@PathVariable("id") Long id) {
        User user = null;
        try {
            user = userService.findById(id);
        } catch (HibernateException e) {
            getLogger().error("Ошибка при поиске пользователя с id={} в таблице Person. Метод /deActivation", id);
            throw new HibernateDBException(e.getMessage());
        }
        if(user == null) {
            getLogger().warn("Пользователь с id {} не найден в таблице Person. Метод /deActivation", id);
            throw new EntityNotFoundException("Пользователь с указаным id=" + id + " не найден в базе данных");
        }
        user.setDeleted(true);
        try {
            userService.update(user);
        } catch (HibernateException e) {
            throw new HibernateDBException(e.getMessage());
        }
        getLogger().info("Пользователь с id={}  успешно деактивирован. Метод /deActivation", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public AbstractService getService() {
        return userService;
    }

    @Override
    public Logger getLogger() {
        return LoggerFactory.getLogger(UserRestController.class);
    }
}
