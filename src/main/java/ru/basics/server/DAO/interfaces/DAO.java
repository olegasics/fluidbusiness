package ru.basics.server.DAO.interfaces;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;


public interface DAO<Entity, Key> {

    void create(Entity entity);
    Entity read(Key key);
    void delete(Entity entity);
    void update(Entity entity);
}
