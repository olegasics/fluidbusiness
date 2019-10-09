package ru.basics.server.database.dao;

import com.sun.istack.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.basics.server.database.entity.Forwarders;
public class ForwarderDAO implements DAO<Forwarders, String> {

    private SessionFactory sessionFactory;

    public ForwarderDAO(@NotNull SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void create(@NotNull Forwarders forwarder) {
            try(Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                session.save(forwarder);
                session.getTransaction().commit();
            }
    }

    @Override
    public Forwarders read(@NotNull final String key) {
        try(@NotNull Session session = sessionFactory.openSession()) {
            final Forwarders forwarder = session.get(Forwarders.class, key);
            return  forwarder != null ? forwarder : null;
        }
    }

    @Override
    public void delete(Forwarders forwarders) {

    }

    @Override
    public void update(Forwarders forwarders) {

    }
}
