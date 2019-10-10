package ru.basics.server.database.dao;

import com.sun.istack.NotNull;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ru.basics.server.database.entity.User;

import org.hibernate.SessionFactory;

import java.util.List;

public class UserDAO extends AbstractDAO<User> {
    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    public boolean exists(String login) {
        return this.findByField("login", login) != null;
    }

}
