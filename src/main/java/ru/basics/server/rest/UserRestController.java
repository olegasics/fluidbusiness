package ru.basics.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.database.dao.AbstractDAO;
import ru.basics.server.database.dao.UserDAO;
import ru.basics.server.database.entity.User;
import ru.basics.server.utils.AuthUtils;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserRestController extends AbstractRestController<User> {

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

    @RequestMapping(value = "/deactivation/{id}", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> deActivation(@PathVariable("id") Long id) {
        User user = userDAO.findById(id);
        if(user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        user.setDeleted(true);
        userDAO.update(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/getstatus", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<User>> getStatus() {
        List<User> users = userDAO.findAllField();
        List<User> users2 = new ArrayList<>();
        for(User user : users) {
            user.setDeleted(false);
            userDAO.update(user);
            users2.add(user);
        }
        return new ResponseEntity<>(users2, HttpStatus.OK);

    }

    @Override
    public AbstractDAO getDao() {
        return userDAO;
    }
}
