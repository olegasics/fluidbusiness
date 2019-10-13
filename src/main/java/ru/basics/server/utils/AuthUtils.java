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
            if (user.getPassword().equals(userDAO.findByField("login", user.getLogin()).get(0).getPassword())) {
                return "AUTH TOKEN"; // TODO Почитай про это и добавь проверку пароля (проверяет пароль в базе, а не у пользователя
            } else {
                return "Password invalid!";
            }
        }

        throw new UserNotFoundException();
    }
}
