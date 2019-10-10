package ru.basics.server.database.dao;
import ru.basics.server.database.entity.CargoMove;
import java.util.Date;
import java.util.List;

public class CargoMoveDAO extends AbstractDAO<CargoMove> {
    @Override
    public Class<CargoMove> getEntityClass() {
        return CargoMove.class;
    }
    public boolean existsProject(String key) {
        return this.findByField("numberProject", key) != null;
    }
    public List<CargoMove> readNumProject(String numProject) {
        return this.findByField("numberProject", numProject);
    }
    public boolean existsDate(Date date) {
        return this.findByField("dateSend", date) != null;
    }
}
