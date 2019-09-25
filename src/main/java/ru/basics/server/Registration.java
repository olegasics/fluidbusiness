package ru.basics.server;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.basics.server.DAO.DAO;
import ru.basics.server.DAO.UserDAO;

public class Registration {

        SessionFactory sessionFactory = null;

        public void newAddUser(String name, int id, String login, String psw, String phone, String city) {

        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            DAO<User, String> userDAO = new UserDAO(sessionFactory);

            User newUser = new User();

            newUser.setLogin(login);
            newUser.setName(name);
            newUser.setId(id);
            newUser.setPassword(psw);
            newUser.setCity(city);
            newUser.setPhone_number(phone);
            userDAO.create(newUser);

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        }


}
