package ru.basics.server.DAO;
import ru.basics.server.User;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class UserDAO implements DAO<User, String> {

    private final SessionFactory sessionFactory = null;

    @Override
    public void create(User user) {

    }

    @Override
    public User read(String s) {
        return null;
    }


    @Override
    public void delete(User user) {

    }

    @Override
    public void update(User user) {

    }
}
