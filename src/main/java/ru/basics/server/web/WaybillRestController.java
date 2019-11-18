package ru.basics.server.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.repository.dao.AbstractDAO;
import ru.basics.server.repository.dao.WayBillDAO;
import ru.basics.server.entity.Waybill;
import ru.basics.server.service.AbstractService;
import ru.basics.server.service.WaybillService;
import sun.nio.cs.ext.MacCentralEurope;

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
    public Logger getLogger() {
        return LoggerFactory.getLogger(WaybillRestController.class);
    }

    @Override
    public AbstractService<Waybill> getService() {
        return waybillService;
    }

    @RequestMapping(value = "/search/{number}",method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Waybill> searchByNumber(@PathVariable Integer number) {
        Waybill waybill = waybillService.findByField("number", number);
        if(waybill == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(waybill, HttpStatus.OK);
    }
}
