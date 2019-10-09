package ru.basics.server.DAO;
import com.sun.istack.NotNull;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ru.basics.server.DAO.interfaces.DAO;
import ru.basics.server.entity.user.User;

import org.hibernate.SessionFactory;

public class UserDAO implements DAO<User, String> {

    /**
     * создаем фабрику сессий. Фабрика сессий - используется для получения объектов Session
     * которые используются для операция с базами данных
     */
    private final SessionFactory sessionFactory;

    public UserDAO(@NotNull SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(@NotNull User user) {
        try (final Session session = sessionFactory.openSession()) {
//            Criteria criteria = session.createCriteria(User.class);
//            criteria.add(Restrictions.eq("login", user.getLogin()));
//            user = (User) criteria.uniqueResult();

            //open transcation
            session.beginTransaction();
            //save object in DB
            session.save(user);
            //commit change object in DBn
            session.getTransaction().commit();
        }
    }

    @Override
    public User read(@NotNull String key) {
        try (final Session session = sessionFactory.openSession()) {
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("login", key));
             User user = (User) criteria.uniqueResult();

//            final User user = session.get(User.class, key);
        return user != null ? user : new User();

        }
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void update(User user) {

    }
}
