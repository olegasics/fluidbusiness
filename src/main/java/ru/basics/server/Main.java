package ru.basics.server;

import ru.basics.server.database.dao.UserDAO;
import ru.basics.server.database.entity.User;
import ru.basics.server.utils.AuthUtils;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        User user = userDAO.findByField("login", "omaslo");
        System.out.println(user.getEmail());
        User pleg = new User("omaslo", "Edc");

        System.out.println(AuthUtils.signIn(pleg));

    }
}
