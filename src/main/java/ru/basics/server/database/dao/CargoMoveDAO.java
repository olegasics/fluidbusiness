package ru.basics.server.database.dao;
import ru.basics.server.database.entity.CargoMove;
import java.util.Date;
import java.util.List;

public class CargoMoveDAO extends AbstractDAO<CargoMove> {
    @Override
    public Class<CargoMove> getEntityClass() {
        return CargoMove.class;
    }


}
