package ru.basics.server.DAO;
import com.sun.istack.NotNull;
import org.hibernate.Session;
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
    public void create(@NotNull final User user) {
        try (final Session session = sessionFactory.openSession()) {
            //open transcation
            session.beginTransaction();
            //save object in DB
            session.save(user);
            //commit change object in DBn
            session.getTransaction().commit();
        }

    }

    @Override
    public User read(@NotNull final String key) {
        try (final Session session = sessionFactory.openSession()) {
            final User user = session.get(User.class, key);
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
