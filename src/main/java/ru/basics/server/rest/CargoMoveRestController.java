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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cargo-moves")
public class CargoMoveRestController extends AbstractRestController<CargoMove> {

    CargoMoveDAO cargoMoveDAO;
    WayBillDAO wayBillDAO;
    DocumentDAO documentDAO;
    List<CargoMove> cargoMoves;

    @Autowired
    public CargoMoveRestController(CargoMoveDAO cargoMoveDAO, WayBillDAO wayBillDAO, DocumentDAO documentDAO) {
        this.cargoMoveDAO = cargoMoveDAO;
        this.wayBillDAO = wayBillDAO;
        this.documentDAO = documentDAO;

    }

    public CargoMoveRestController() {
    }


    @RequestMapping(value = "/search/waybills/{id}", method = RequestMethod.GET,
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

    @RequestMapping(value = "/search/invoice/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<CargoMove>> findByInvoice(@PathVariable("id") Integer documentNumber) {
        Document document = documentDAO.findByField("name", documentNumber);
        if(document == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        CargoMove cargoMove = cargoMoveDAO.findByField("waybillDocuments", document);
        if (cargoMove == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        do {
            cargoMoves.add(cargoMove);
            cargoMove = cargoMoveDAO.findByField("waybillDocuments", document);
        } while (cargoMove != null);

        return new ResponseEntity<>(cargoMoves, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/search/track-number/{track}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<CargoMove>> findByTrackNumber(@PathVariable("track") String trackNumber) {
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

    @Override
    public AbstractDAO getDao() {
        return cargoMoveDAO;
    }
}
