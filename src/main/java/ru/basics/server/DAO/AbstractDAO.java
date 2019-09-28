//package ru.basics.server.DAO;
//
//import com.sun.istack.NotNull;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import ru.basics.server.entity.user.User;
//
//public abstract class AbstractDAO<Entity, Key> {
//
//    SessionFactory sessionFactory = null;
//
//     public void create(Entity entity) {
//        try (final Session session = sessionFactory.openSession()) {
//            //open transcation
//            session.beginTransaction();
//            //save object in DB
//            session.save(entity);
//            //commit change object in DBn
//            session.getTransaction().commit();
//        }
//    }
//    Entity read(@NotNull Key key) {
//         try (final Session session = sessionFactory.openSession()) {
//                final Entity entity = session.get(Entity.class, key);
//                return  entity != null ? entity : new Entity();
//
//            }
//    }
//    void delete(Entity entity) {}
//    void update(Entity entity) {}
//
//
//}
