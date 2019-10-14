package ru.basics.server.utils;

import ru.basics.server.database.dao.UserDAO;
import ru.basics.server.database.entity.User;
import ru.basics.server.database.exceptions.UserAlreadyExistsException;
import ru.basics.server.database.exceptions.UserNotFoundException;

public class AuthUtils {
    private static final UserDAO userDAO = new UserDAO();
    private static String userPasswordInFiled;
    private static String passwordInDB;
    private static String userLoginInFiled;

    public static User signUp(User user) throws UserAlreadyExistsException {
        if (!userDAO.exists(user.getLogin())) {
            return userDAO.create(user);
        }

        throw new UserAlreadyExistsException();
    }

    public static String signIn(User user) throws UserNotFoundException {
        userLoginInFiled = user.getLogin();
        if (userDAO.exists(userLoginInFiled)) {
            userPasswordInFiled = user.getPassword();
            passwordInDB = userDAO.findByField("login", userLoginInFiled).get(0).getPassword();
            if (userPasswordInFiled.equals(passwordInDB)) {
                return "AUTH TOKEN"; // TODO Почитай про это
            } else {
                return "Password invalid!";
            }
        }

        throw new UserNotFoundException();
    }
}
