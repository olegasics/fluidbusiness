package ru.basics.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basics.server.repository.dao.AbstractDAO;
import ru.basics.server.entity.DriverData;
import ru.basics.server.repository.dao.DriverDataDAO;

import javax.transaction.Transactional;

@Service
@Transactional
public class DriverDataService extends AbstractService<DriverData> {
    @Autowired
    DriverDataDAO driverDataDAO;

    @Override
    public AbstractDAO getDao() {
        return driverDataDAO;
    }
}


