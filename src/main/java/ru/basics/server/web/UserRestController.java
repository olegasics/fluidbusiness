package ru.basics.server.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.repository.dao.AbstractDAO;
import ru.basics.server.repository.dao.UserDAO;
import ru.basics.server.entity.User;
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
    final static Logger logger = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    public UserRestController(AuthUtils authUtils, UserService userService) {
        this.authUtils = authUtils;
        this.userService = userService;
    }

    public UserRestController() {
    }

    /**
     * Регистрация User
     *
     * @param
     * @return
     */

//    @RequestMapping(value = "/test", method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public List<User> all() {
//        return (List<User>) userService.findAllField();
//    }

    @RequestMapping(value = "/deactivation/{id}", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> deActivation(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        if(user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        user.setDeleted(true);
        userService.update(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/getstatus", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<User>> getStatus() {
        List<User> users = userService.findAllField();
        List<User> users2 = new ArrayList<>();
        for(User user : users) {
            user.setDeleted(false);
            userService.update(user);
            users2.add(user);
        }
        logger.info("test");
        return new ResponseEntity<>(users2, HttpStatus.OK);
    }

    @Override
    public AbstractService getService() {
        return userService;
    }
}
