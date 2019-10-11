package ru.basics.server.database.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import ru.basics.server.database.entity.AbstractPerson;
import ru.basics.server.database.entity.User;
import ru.basics.server.utils.SessionFactoryUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
            CriteriaQuery<T> criteriaQuery = null;
              criteria =  session.createCriteria(this.getEntityClass())
                    .add(Restrictions.eq(field, key));

//            EntityManagerFactory entityManagerFactory = Persistence
//                    .createEntityManagerFactory("test");
//            EntityManager em = entityManagerFactory.createEntityManager();
//
//            em.getTransaction().begin();
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<T> cq = cb.createQuery(this.getEntityClass());
//            Root<T> root = criteriaQuery.from(this.getEntityClass());
//            criteriaQuery = criteriaQuery.select(root).where(cb.equal(root.get(field), key));
//           return (List<T>) criteriaQuery.getOrderList();
            return criteria.list();
        }
    }
    public abstract Class<T> getEntityClass();
}