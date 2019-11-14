package ru.basics.server.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basics.server.database.dao.AbstractDAO;
import ru.basics.server.database.dao.CargoMoveDAO;
import ru.basics.server.database.entity.CargoMove;

import javax.transaction.Transactional;

@Service
@Transactional
public class CargoMoveService extends AbstractService<CargoMove> {

    @Autowired
    CargoMoveDAO cargoMoveDAO;

    @Override
    public AbstractDAO getDao() {
        return cargoMoveDAO;
    }


}
