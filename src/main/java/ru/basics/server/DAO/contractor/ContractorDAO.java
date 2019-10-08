package ru.basics.server.DAO.contractor;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.basics.server.DAO.DAO;

public class ContractorDAO implements DAO {

    SessionFactory sessionFactory = null;
    @Autowired
    public ContractorDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Object o) {

    }

    @Override
    public Object read(Object o) {
        return null;
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void update(Object o) {

    }
}
