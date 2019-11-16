package ru.basics.server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.repository.dao.AbstractDAO;
import ru.basics.server.repository.dao.DriverDataDAO;
import ru.basics.server.entity.Company;
import ru.basics.server.entity.DriverData;
import ru.basics.server.service.AbstractService;
import ru.basics.server.service.DriverDataService;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverDataRestController extends AbstractRestController<DriverData> {
    DriverDataService driverDataService;
    List<DriverData> driverDataList;

    @Autowired
    public DriverDataRestController(DriverDataService driverDataService) {
        this.driverDataService = driverDataService;
    }

    public DriverDataRestController() {
    }

    @RequestMapping(value = "/search/{name}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<DriverData> findByName(@PathVariable("name") String name) {
        if (name == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        DriverData driverData = driverDataService.findByField("name", name);
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

        DriverData driverData = driverDataService.findByField("modelcar", model);
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

        DriverData driverData = driverDataService.findByField("numberphone", number);
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
        // TODO изменить поиск. Выгрузить всех водителей и проверять пренадлежат ли компании из запроса
        DriverData driverData = driverDataService.findByField("company", company);
        if (driverData == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        do {
            driverDataList.add(driverData);
            driverData = driverDataService.findByField("company", company);
        } while (driverData != null);

        return new ResponseEntity<>(driverDataList, HttpStatus.OK);
    }


    @Override
    public AbstractService getService() {
        return driverDataService;
    }
}