package ru.basics.server.database.dao;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import ru.basics.server.database.entity.Project;
import ru.basics.server.utils.SessionFactoryUtils;
import javax.persistence.MappedSuperclass;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@MappedSuperclass
@Service
@Transactional
public abstract class AbstractDAO<T> implements Serializable {
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

    public T findByField(String field, Object key) {
        try (Session session = sessionFactory.openSession()) {
            criteria =  session.createCriteria(this.getEntityClass())
                    .add(Restrictions.eq(field, key));
            return (T) criteria.uniqueResult();
        }
    }

    public List<T> findAllField(){
        try(Session session = sessionFactory.openSession()) {
            return session.createCriteria(this.getEntityClass()).list();
        }
    }

    public void update(T entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        }
        //return entity;
    }

    public void delete(T entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        }
    }

    public boolean isExistWithString(Long id) {
        //TODO  сделать поиск по логину
        return findById() != null;
    }

    public abstract Class<T> getEntityClass();
}