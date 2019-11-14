package ru.basics.server.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basics.server.database.dao.AbstractDAO;
import ru.basics.server.database.entity.DriverData;

import javax.transaction.Transactional;

@Service
@Transactional
public class DriverDataService extends AbstractService<DriverData> {
    @Autowired
    AbstractDAO abstractDAO;

    @Override
    public AbstractDAO getDao() {
        return null;
    }
}


