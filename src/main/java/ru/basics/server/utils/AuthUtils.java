package ru.basics.server.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.basics.server.database.dao.UserDAO;
import ru.basics.server.database.entity.User;
import ru.basics.server.database.exceptions.UserAlreadyExistsException;
import ru.basics.server.database.exceptions.UserNotFoundException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/log/api/v1")
public class AuthUtils {
    private static UserDAO userDAO = new UserDAO();
    static List<User> userAuth = new ArrayList<>();

    @RequestMapping(value = "", path = "reg", produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public static User signUp(User user) throws UserAlreadyExistsException {
        HttpHeaders httpHeaders = new HttpHeaders();

        if (!userDAO.exists(user.getLogin())) {
            return userDAO.create(user);
        }

        return null;
    }

    public static String signIn(User user) throws UserNotFoundException {
        String userLoginInFiled = user.getLogin();

        if (userDAO.exists(userLoginInFiled)) {
            String userPasswordInFiled = user.getPassword();
            String passwordInDB = userDAO.findByField("login", userLoginInFiled).getPassword();

            if (userPasswordInFiled.equals(passwordInDB)) {
                userAuth.add(user);
                return "AUTH TOKEN"; // TODO Почитай про это
            } else {
                return "Password invalid!";
            }
        }

        throw new UserNotFoundException();
    }
}
