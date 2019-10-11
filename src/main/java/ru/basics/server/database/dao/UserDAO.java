package ru.basics.server.database.dao;

import ru.basics.server.database.entity.User;

public class UserDAO extends AbstractDAO<User> {
    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    public boolean exists(String login) {
        return this.findByField("login", login) != null;
    }

}
