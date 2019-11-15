package ru.basics.server.repository.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.basics.server.entity.User;

@Service
@Transactional
public class UserDAO extends AbstractDAO<User>{
    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    public boolean exists(String login) {
        User user = this.findByField("login", login);
        if(user != null) {
            if(!user.getDeleted()) {
                return true;
            }
        }
        return false;
    }

}
