package ru.basics.server.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.basics.server.database.dao.AbstractDAO;
import ru.basics.server.database.dao.WayBillDAO;
import ru.basics.server.database.entity.Waybill;

public class WaybillService extends AbstractService<Waybill> {
    @Autowired
    WayBillDAO wayBillDAO;

    @Override
    public AbstractDAO getDao() {
        return wayBillDAO;
    }


}
