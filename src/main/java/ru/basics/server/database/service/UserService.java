package ru.basics.server.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basics.server.database.dao.AbstractDAO;
import ru.basics.server.database.dao.UserDAO;
import ru.basics.server.database.entity.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService extends AbstractService<User> {

    @Autowired
    UserDAO userDAO;

    @Override
    public AbstractDAO getDao() {
        return userDAO;
    }


}
