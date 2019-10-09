package ru.basics.server.DAO.contractor;

import com.sun.istack.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.basics.server.DAO.interfaces.DAO;
import ru.basics.server.entity.contractor.Contractor;

public class ContractorDAO implements DAO<Contractor, String> {

    SessionFactory sessionFactory = null;
    @Autowired
    public ContractorDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Contractor contractor) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(contractor);
            session.getTransaction().commit();

        }

    }

    @Override
    public Contractor read(@NotNull final String key) {

        try(Session session = sessionFactory.openSession()) {
            Contractor contractor = (Contractor) session.get(Contractor.class, key);
            return contractor != null ?  contractor : null;
        }
    }

    @Override
    public void delete(Contractor contractor) {

    }

    @Override
    public void update(Contractor contractor) {

    }
}
