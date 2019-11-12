package ru.basics.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.database.dao.AbstractDAO;
import ru.basics.server.database.dao.WayBillDAO;
import ru.basics.server.database.entity.Waybill;

@RestController
@RequestMapping(value = "/waybills")
public class WaybillRestController extends AbstractRestController<Waybill> {

    WayBillDAO wayBillDAO;

    @Autowired
    public WaybillRestController(WayBillDAO wayBillDAO) {
        this.wayBillDAO = wayBillDAO;
    }

    public WaybillRestController() {
    }

    @Override
    public AbstractDAO getDao() {
        return wayBillDAO;
    }
}
