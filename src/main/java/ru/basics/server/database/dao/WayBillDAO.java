package ru.basics.server.database.dao;

import ru.basics.server.database.entity.Waybill;

public class WayBillDAO extends AbstractDAO<Waybill> {


    @Override
    public Class<Waybill> getEntityClass() {
        return Waybill.class;
    }
}
