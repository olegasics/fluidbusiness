package ru.basics.server.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface DAO<Entity, Key> {

    void create(Entity entity);
    Entity read(Key key);
    void delete(Entity entity);
    void update(Entity entity);
}
