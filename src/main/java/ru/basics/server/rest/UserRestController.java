package ru.basics.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.basics.server.database.dao.UserDAO;
import ru.basics.server.database.entity.User;
import ru.basics.server.utils.AuthUtils;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserRestController {

    UserDAO userDAO;
    AuthUtils authUtils;

    @Autowired
    public UserRestController(UserDAO userDAO, AuthUtils authUtils) {
        this.userDAO = userDAO;
        this.authUtils = authUtils;
    }

    public UserRestController() {
    }

    /**
     * Регистрация User
     *
     * @param user
     * @return
     */
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<User> registration(@RequestBody @Valid User user) {
        HttpHeaders headers = new HttpHeaders();

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (AuthUtils.signUp(user) == null) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity(user, headers, HttpStatus.CREATED);

    }

    @RequestMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    public ResponseEntity<User> login(@PathVariable("id") Long id) {
        User user = userDAO.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);


    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    public ResponseEntity<List<User>> all() {

        return new ResponseEntity<>(userDAO.findAllField(), HttpStatus.OK);

    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PATCH)
    public ResponseEntity<User> update(@RequestBody @Valid User user) {
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (!userDAO.exists(user.getLogin())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userDAO.update(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
