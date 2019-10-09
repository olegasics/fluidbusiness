package ru.basics.server.database.dao;

import com.sun.istack.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.basics.server.database.entity.CargoMove;

public class CargoMoveDAO implements DAO<CargoMove, String> {

    private final SessionFactory sessionFactory;

    public CargoMoveDAO(@NotNull SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(@NotNull CargoMove cargoMove) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(cargoMove);
            session.getTransaction().commit();
        }
    }

    @Override
    public CargoMove read(String key) {
        try (Session session = sessionFactory.openSession()) {
            final CargoMove cargoMove = session.get(CargoMove.class, key);
            return cargoMove != null ? cargoMove : new CargoMove();
        }
    }

    @Override
    public void delete(CargoMove cargoMove) {

    }

    @Override
    public void update(CargoMove cargoMove) {

    }
}
