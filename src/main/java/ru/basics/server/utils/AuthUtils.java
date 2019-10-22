package ru.basics.server.utils;

import ru.basics.server.database.dao.UserDAO;
import ru.basics.server.database.entity.User;
import ru.basics.server.database.exceptions.UserAlreadyExistsException;
import ru.basics.server.database.exceptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class AuthUtils {
    private static final UserDAO userDAO = new UserDAO();
    static List<User> userAuth = new ArrayList<>();

    public static User signUp(User user) throws UserAlreadyExistsException {
        if (!userDAO.exists(user.getLogin())) {
            return userDAO.create(user);
        }

        throw new UserAlreadyExistsException();
    }

    public static String signIn(User user) throws UserNotFoundException {
        String userLoginInFiled = user.getLogin();

        if (userDAO.exists(userLoginInFiled)) {
            String userPasswordInFiled = user.getPassword();
            String passwordInDB = userDAO.findByField("login", userLoginInFiled).get(0).getPassword();

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
