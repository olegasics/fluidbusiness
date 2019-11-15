package ru.basics.server.repository.dao;

import org.springframework.stereotype.Service;
import ru.basics.server.entity.CargoMove;

import javax.transaction.Transactional;

@Service
@Transactional
public class CargoMoveDAO extends AbstractDAO<CargoMove> {
    @Override
    public Class<CargoMove> getEntityClass() {
        return CargoMove.class;
    }

}
