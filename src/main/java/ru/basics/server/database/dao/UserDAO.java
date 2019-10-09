package ru.basics.server.database.dao;

import com.sun.istack.NotNull;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ru.basics.server.database.entity.User;

import org.hibernate.SessionFactory;

public class UserDAO extends AbstractDAO<User> {
    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    public User findByLogin(@NotNull String key) {
        try (final Session session = sessionFactory.openSession()) {
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("login", key));

            return (User) criteria.uniqueResult();
        }
    }

    public boolean exists(String login) {
        return this.findByLogin(login) != null;
    }
}
