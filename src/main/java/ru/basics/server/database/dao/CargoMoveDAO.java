package ru.basics.server.database.dao;
import ru.basics.server.database.entity.CargoMove;

public class CargoMoveDAO extends AbstractDAO<CargoMove> {
    @Override
    public Class<CargoMove> getEntityClass() {
        return CargoMove.class;
    }


}
