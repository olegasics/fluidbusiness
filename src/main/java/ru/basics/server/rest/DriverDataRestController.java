package ru.basics.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.database.dao.AbstractDAO;
import ru.basics.server.database.dao.DriverDataDAO;
import ru.basics.server.database.entity.Company;
import ru.basics.server.database.entity.Document;
import ru.basics.server.database.entity.DriverData;

import java.rmi.MarshalException;
import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverDataRestController extends AbstractRestController<DriverData> {
    DriverDataDAO driverDataDAO;
    List<DriverData> driverDataList;

    @Autowired
    public DriverDataRestController(DriverDataDAO driverDataDAO) {
        this.driverDataDAO = driverDataDAO;
    }

    public DriverDataRestController() {
    }

    @Override
    public AbstractDAO getDao() {
        return driverDataDAO;
    }

    @RequestMapping(value = "/search/{name}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<DriverData> findByName(@PathVariable("name") String name) {
        if (name == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        DriverData driverData = driverDataDAO.findByField("name", name);
        if (driverData == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(driverData, HttpStatus.OK);
    }

    @RequestMapping(value = "/search/model-car/{modelcar}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<DriverData> findByModelCar(@PathVariable("modelcar") String model) {
        if (model == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        DriverData driverData = driverDataDAO.findByField("modelcar", model);
        if (driverData == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(driverData, HttpStatus.OK);
    }

    @RequestMapping(value = "/search/phone/{number}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<DriverData> findByNumberPhone(@PathVariable("number") String number) {
        if (number == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        DriverData driverData = driverDataDAO.findByField("numberphone", number);
        if (driverData == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(driverData, HttpStatus.OK);
    }

    @RequestMapping(value = "/search/company", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<DriverData>> findByCompany(Company company) {
        if (company == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        // TODO or findByObject?
        DriverData driverData = driverDataDAO.findByField("company", company);
        if (driverData == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        do {
            driverDataList.add(driverData);
            driverData = driverDataDAO.findByField("company", company);
        } while (driverData != null);

        return new ResponseEntity<>(driverDataList, HttpStatus.OK);
    }


}
