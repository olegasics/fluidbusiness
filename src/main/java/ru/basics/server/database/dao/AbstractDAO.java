package ru.basics.server.database.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
    public T findByField(String field, Object key) {
        try (Session session = sessionFactory.openSession()) {
            Criteria criteria = session.createCriteria(this.getEntityClass(), String.valueOf(key));
            criteria.add(Restrictions.eq(field, key));
            return (T) criteria.uniqueResult();
        }
    }
    public abstract Class<T> getEntityClass();
}