package ru.basics.server.database.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.basics.server.database.entity.DriverData;

@Service
@Transactional
public class DriverDataDAO extends AbstractDAO<DriverData> {
    @Override
    public Class<DriverData> getEntityClass() {
        return DriverData.class;
    }
}
