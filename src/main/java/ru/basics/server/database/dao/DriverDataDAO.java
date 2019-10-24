package ru.basics.server.database.dao;

import ru.basics.server.database.entity.DriverData;

public class DriverDataDAO extends AbstractDAO<DriverData> {
    @Override
    public Class<DriverData> getEntityClass() {
        return DriverData.class;
    }
}
