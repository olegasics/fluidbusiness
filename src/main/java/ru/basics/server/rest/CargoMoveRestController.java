package ru.basics.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.database.dao.CargoMoveDAO;
import ru.basics.server.database.dao.WayBillDAO;
import ru.basics.server.database.dao.WaybillDocumentDAO;
import ru.basics.server.database.entity.CargoMove;
import ru.basics.server.database.entity.Waybill;
import ru.basics.server.database.entity.WaybillDocument;

import java.util.List;

@RestController
@RequestMapping("/cargro-moves")
public class CargoMoveRestController implements RestControllerInterface<CargoMove> {

    CargoMoveDAO cargoMoveDAO;

    @Autowired
    public CargoMoveRestController(CargoMoveDAO cargoMoveDAO) {
        this.cargoMoveDAO = cargoMoveDAO;
    }

    public CargoMoveRestController() {
    }

    @RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.GET)
    public ResponseEntity<CargoMove> test() {


        WayBillDAO wayBillDAO = new WayBillDAO();
        Waybill waybill = wayBillDAO.findById(86L);
        WaybillDocumentDAO waybillDocumentDAO = new WaybillDocumentDAO();
        WaybillDocument waybillDocument = waybillDocumentDAO.findById(1L);
        WaybillDocument waybillDocument1 = waybillDocumentDAO.findById(2L);
        waybillDocument.setWaybill(waybill);
        waybillDocument1.setWaybill(waybill);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<CargoMove> add(CargoMove cargoMove) {
        if(cargoMove == null) {
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
        if(cargoMove == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(cargoMove, HttpStatus.OK);
    }

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
}
