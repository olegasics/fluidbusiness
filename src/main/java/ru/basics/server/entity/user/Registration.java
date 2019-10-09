package ru.basics.server.entity.user;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import ru.basics.server.DAO.interfaces.DAO;
import ru.basics.server.DAO.UserDAO;
import ru.basics.server.connection.SessionFactoryUtil;

public class Registration extends CheckUserValid {

        SessionFactory sessionFactory = null;

        public void newAddUser(String name, String login, String psw, String phone, String city) {

        try {
            sessionFactory = SessionFactoryUtil.getInstance();
            DAO<User, String> userDAO = new UserDAO(sessionFactory);
            User newUser = new User();

            if(checkUserForRegistration(login, newUser, userDAO) == 1) {
                System.out.println("Такой пользователь уже существует");
            } else {
                newUser.setLogin(login);
                newUser.setName(name);
                newUser.setPassword(psw);
                newUser.setCity(city);
                newUser.setPhone_number(phone);
                userDAO.create(newUser);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        }


}
