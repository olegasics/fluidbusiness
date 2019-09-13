package main.java.ru.basics.server.DBconnection.DAO;

public interface DAO<Entity, Key> {
    boolean create(Entity model);
    boolean update(Entity model);
    boolean delete(Entity model);
    Entity read(Key key);

}
