package ru.basics.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basics.server.repository.dao.AbstractDAO;
import ru.basics.server.repository.dao.WayBillDAO;
import ru.basics.server.entity.Waybill;

import javax.transaction.Transactional;

@Service
@Transactional
public class WaybillService extends AbstractService<Waybill> {
    @Autowired
    WayBillDAO wayBillDAO;

    @Override
    public AbstractDAO getDao() {
        return wayBillDAO;
    }


}
