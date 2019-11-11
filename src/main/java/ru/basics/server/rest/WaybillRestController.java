package ru.basics.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.database.dao.WayBillDAO;
import ru.basics.server.database.entity.Waybill;
import java.util.List;

@RestController
@RequestMapping(value = "/waybills")
public class WaybillRestController extends RestControllerInterface<Waybill, WayBillDAO> {

    WayBillDAO wayBillDAO;

    @Autowired
    public WaybillRestController(WayBillDAO wayBillDAO) {
        this.wayBillDAO = wayBillDAO;
    }

    public WaybillRestController() {
    }
    /*
    @Override
    public ResponseEntity<Waybill> add(Waybill waybill) {
        if (waybill == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        wayBillDAO.create(waybill);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<Waybill>> all() {
        List<Waybill> waybills = wayBillDAO.findAllField();
        return new ResponseEntity<>(waybills, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Waybill> getById(@PathVariable("id") Long id) {
        Waybill waybill = wayBillDAO.findById(id);
        if (waybill == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(waybill, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Waybill> update(Waybill waybill) {
        if (waybill == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        wayBillDAO.update(waybill);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Waybill> delete(Waybill waybill) {
        if (waybill == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (wayBillDAO.findById(waybill.getId()) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        wayBillDAO.delete(waybill);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Waybill> deleteById(Long id) {
        Waybill waybill = wayBillDAO.findById(id);
        if (waybill == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        wayBillDAO.delete(waybill);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

     */
}
