package ru.basics.server.database.dao;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.basics.server.database.entity.User;

@Service
@Transactional
public class UserDAO extends AbstractDAO<User>{
    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    public boolean exists(String login) {
        return this.findByField("login", login) != null;
    }

}
