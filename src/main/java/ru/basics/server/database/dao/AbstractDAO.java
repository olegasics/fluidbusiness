package ru.basics.server.database.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.basics.server.utils.SessionFactoryUtils;

public abstract class AbstractDAO<T> {
    SessionFactory sessionFactory;

    public AbstractDAO() {
        this.sessionFactory = SessionFactoryUtils.getInstance();
    }

    public T create(T entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();

            return entity;
        }
    }

    public T findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(this.getEntityClass(), id);
        }
    }

    public abstract Class<T> getEntityClass();
}