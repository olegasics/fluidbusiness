package ru.basics.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.database.dao.UserDAO;
import ru.basics.server.database.entity.User;
import ru.basics.server.utils.AuthUtils;

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

    @RequestMapping(value = "/reg", produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<User> registration(@RequestBody User user) {

        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }

        if (AuthUtils.signUp(user) == null) {
            return new ResponseEntity<User>(HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<User>(HttpStatus.CREATED);

    }

    @RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<User> login(@RequestBody User user) {
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        if(AuthUtils.signIn(user) == null) {
            return new ResponseEntity<User>(HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<User>(HttpStatus.OK);
    }

    @RequestMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    public ResponseEntity<List<User>> all() {

        return new ResponseEntity<>(userDAO.findAllField(), HttpStatus.OK);

    }
}
