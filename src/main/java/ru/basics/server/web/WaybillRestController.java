package ru.basics.server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.repository.dao.AbstractDAO;
import ru.basics.server.repository.dao.WayBillDAO;
import ru.basics.server.entity.Waybill;
import ru.basics.server.service.AbstractService;
import ru.basics.server.service.WaybillService;

@RestController
@RequestMapping(value = "/waybills")
public class WaybillRestController extends AbstractRestController<Waybill> {

    WaybillService waybillService;

    @Autowired
    public WaybillRestController(WaybillService waybillService) {
        this.waybillService = waybillService;
    }

    public WaybillRestController() {
    }

    @Override
    public AbstractService<Waybill> getService() {
        return waybillService;
    }
}
