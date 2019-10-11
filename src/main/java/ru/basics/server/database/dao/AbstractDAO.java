package ru.basics.server.database.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import ru.basics.server.utils.SessionFactoryUtils;
import java.util.List;

public abstract class AbstractDAO<T> {
    SessionFactory sessionFactory;
    Criteria criteria;

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
    public List<T> findByField(String field, Object key) {
        try (Session session = sessionFactory.openSession()) {
              criteria =  session.createCriteria(this.getEntityClass())
                    .add(Restrictions.eq(field, key));
           return criteria.list();
        }
    }

    public abstract Class<T> getEntityClass();
}