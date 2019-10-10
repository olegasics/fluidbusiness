package ru.basics.server.utils;

import ru.basics.server.database.dao.UserDAO;
import ru.basics.server.database.entity.User;
import ru.basics.server.database.exceptions.UserAlreadyExistsException;
import ru.basics.server.database.exceptions.UserNotFoundException;

public class AuthUtils {
    private static final UserDAO userDAO = new UserDAO();

    public static User signUp(User user) throws UserAlreadyExistsException {
        if (!userDAO.exists(user.getLogin())) {
            return userDAO.create(user);
        }

        throw new UserAlreadyExistsException();
    }

    public static String signIn(User user) throws UserNotFoundException {
        if (userDAO.exists(user.getLogin())) {

            return "AUTH TOKEN"; // TODO Почитай про это и добавь проверку пароля
        }

        throw new UserNotFoundException();
    }
}
