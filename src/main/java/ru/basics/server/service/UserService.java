package ru.basics.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basics.server.repository.dao.AbstractDAO;
import ru.basics.server.repository.dao.UserDAO;
import ru.basics.server.entity.User;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService extends AbstractService<User> {


    UserDAO userDAO;

    public UserService() {}
    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public AbstractDAO getDao() {
        return userDAO;
    }


}
