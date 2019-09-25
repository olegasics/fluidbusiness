package ru.basics.server;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.basics.server.DAO.DAO;
import ru.basics.server.DAO.UserDAO;

public class CheckUserValid  {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    //DAO<User, String> userDAO = new UserDAO(sessionFactory);
    Boolean checkValid;
    Boolean checkIsExist;

    public boolean checkUserForRegistration(String login, User user, DAO<User,String> userDAO) {
         user = userDAO.read(login);
            if(user.getLogin() != null) {
                 checkIsExist = false;
            } else checkIsExist = true;

            return checkIsExist;
    }

    public boolean checkUserForAuth(String login, String password, User user, DAO<User, String> userDAO) {
         user = userDAO.read(login);
        if(checkUserForRegistration(login, user, userDAO)) {
            if (password.equals(user.getPassword())) {
                checkValid = true;

            } else {
                System.out.println("Введен не верный пароль");
                checkValid = false;
            }
        } else {
            checkValid = false;
        }
        return checkValid;
        }

}


