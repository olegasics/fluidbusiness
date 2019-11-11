package ru.basics.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.database.dao.DriverDataDAO;
import ru.basics.server.database.entity.DriverData;
import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverDataRestController extends RestControllerInterface<DriverData, DriverDataDAO> {
    DriverDataDAO driverDataDAO;

    @Autowired
    public DriverDataRestController(DriverDataDAO driverDataDAO) {
        this.driverDataDAO = driverDataDAO;
    }

    public DriverDataRestController() {
    }
    /*
    @Override
    public ResponseEntity<DriverData> add(DriverData driverData) {
        if(driverData == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        driverDataDAO.create(driverData);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<DriverData>> all() {
        List<DriverData> driverData = driverDataDAO.findAllField();
        return new ResponseEntity<>(driverData, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DriverData> getById(Long id) {
        DriverData driverData = driverDataDAO.findById(id);
        if(driverData == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(driverData, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DriverData> update(DriverData driverData) {
        if(driverData == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        driverDataDAO.update(driverData);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<DriverData> delete(DriverData driverData) {
        if(driverData == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(driverDataDAO.findById(driverData.getId()) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        driverDataDAO.delete(driverData);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<DriverData> deleteById(Long id) {
        DriverData driverData = driverDataDAO.findById(id);
        if(driverData == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        driverDataDAO.delete(driverData);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }

     */


}
