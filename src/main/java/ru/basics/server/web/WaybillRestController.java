package ru.basics.server.web;

import org.hibernate.HibernateException;
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
import ru.basics.server.repository.exceptions.EntityNotFoundException;
import ru.basics.server.repository.exceptions.HibernateDBException;
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
    public Logger getLogger() {
        return LoggerFactory.getLogger(WaybillRestController.class);
    }

    @Override
    public Class<Waybill> getEntityClass() {
        return Waybill.class;
    }

    @Override
    public AbstractService<Waybill> getService() {
        return waybillService;
    }

    @RequestMapping(value = "/search/{number}",method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Waybill> searchByNumber(@PathVariable Integer number) {
        Waybill waybill = null;
        try {
            waybill = waybillService.findByField("number", number);
        } catch (HibernateException e) {
            getLogger().error("Ошибка при поиске ТТН с номером {} в таблице Waybill, метод /searchByNumber. Стек: {}",
                    number, e.getMessage());
            throw new HibernateDBException(e.getMessage());
        }
        if(waybill == null) {
            getLogger().warn("Не найдена ТТН с номер {} в базе данных. Метод /searchByNumber", number);
            throw new EntityNotFoundException("ТТН с номером " + number + " не найдена в базе данных");
        }
        return new ResponseEntity<>(waybill, HttpStatus.OK);
    }
}
