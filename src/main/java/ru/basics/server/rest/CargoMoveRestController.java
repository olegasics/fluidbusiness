package ru.basics.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.database.dao.*;
import ru.basics.server.database.entity.*;
import ru.basics.server.utils.restUtils.RestUtils;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cargo-moves")
public class CargoMoveRestController extends RestControllerInterface<CargoMove> {

    CargoMoveDAO cargoMoveDAO;
    WayBillDAO wayBillDAO;
    DocumentDAO documentDAO;

    @Autowired
    public CargoMoveRestController(CargoMoveDAO cargoMoveDAO, WayBillDAO wayBillDAO, DocumentDAO documentDAO) {
        this.cargoMoveDAO = cargoMoveDAO;
        this.wayBillDAO = wayBillDAO;
        this.documentDAO = documentDAO;
    }

    public CargoMoveRestController() {
    }

    /*
    @Override
    public ResponseEntity<CargoMove> add(CargoMove cargoMove) {
        if(RestUtils.checkIsNullBool(cargoMove)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        cargoMoveDAO.create(cargoMove);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    @Override
    public ResponseEntity<List<CargoMove>> all() {
        return new ResponseEntity<>(cargoMoveDAO.findAllField(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CargoMove> getById(Long id) {
        CargoMove cargoMove = cargoMoveDAO.findById(id);
        RestUtils.checkIsNullBool(cargoMove);
        if(cargoMove == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(cargoMove, HttpStatus.OK);
    }

     */

    @Override
    public ResponseEntity<CargoMove> update(CargoMove cargoMove) {
        if(cargoMove == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        cargoMoveDAO.update(cargoMove);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<CargoMove> delete(CargoMove cargoMove) {
        if(cargoMove == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(cargoMoveDAO.findById(cargoMove.getId()) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        cargoMoveDAO.delete(cargoMove);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<CargoMove> deleteById(Long id) {
        CargoMove cargoMove = cargoMoveDAO.findById(id);
        if(cargoMove == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        cargoMoveDAO.delete(cargoMove);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping(value = "/waybills/{id}", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<CargoMove>> findByWaybill(@PathVariable("id") Integer number) {
        List<CargoMove> cargoMoves = new ArrayList<>();
        if(number == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Waybill waybill = wayBillDAO.findByField("number", number);
        if(waybill == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        CargoMove cargoMove = cargoMoveDAO.findByField("waybill", waybill);
        if(cargoMove == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        cargoMoves.add(cargoMove);

        return new ResponseEntity<>(cargoMoves, HttpStatus.OK);

    }

    public ResponseEntity<List<CargoMove>> findByInvoice(Integer documentNumber) {
        Document document = documentDAO.findByField("name", documentNumber);
        if(document == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        CargoMove cargoMove = cargoMoveDAO.findByField("document", document);
        //TODO сделать филд document(invoice) в CargoMove
        return  null;
    }

    public ResponseEntity<List<CargoMove>> findByTrackNumber(String trackNumber) {
        if(trackNumber == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        CargoMove cargoMove = cargoMoveDAO.findByField("tracknumber", trackNumber);
        if(cargoMove == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<CargoMove> cargoMoves = new ArrayList<>();
        cargoMoves.add(cargoMove);
        return new ResponseEntity<>(cargoMoves, HttpStatus.OK);
    }



}
