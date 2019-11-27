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
import ru.basics.server.repository.dao.DriverDataDAO;
import ru.basics.server.entity.Company;
import ru.basics.server.entity.DriverData;
import ru.basics.server.repository.exceptions.BadRequestException;
import ru.basics.server.repository.exceptions.EntityNotFoundException;
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

    @Override
    public Logger getLogger() {
        return LoggerFactory.getLogger(DriverDataRestController.class);
    }

    @Override
    public Class<DriverData> getEntityClass() {
        return DriverData.class;
    }

    @RequestMapping(value = "/search/{name}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<DriverData> findByName(@PathVariable String name) {
        if (name == null) {
            throw new BadRequestException("Неверный запрос. Водитель не может быть:" + name);
        }

        DriverData driverData = driverDataService.findByField("name", name);
        if (driverData == null) {
            throw new EntityNotFoundException("Водителя с именем: " + name + " не найдено в базе данных");
        }

        return new ResponseEntity<>(driverData, HttpStatus.OK);
    }

    @RequestMapping(value = "/search/model-car/{model-car}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<DriverData> findByModelCar(@PathVariable("model-car") String model) {
        if (model == null) {
            throw new BadRequestException("Неверный запрос. Машина не может быть:" + model);
        }

        DriverData driverData = driverDataService.findByField("modelcar", model);
        if (driverData == null) {
            throw new EntityNotFoundException("Водителя с машиной: " + model + " не найдено в базе данных");
        }

        return new ResponseEntity<>(driverData, HttpStatus.OK);
    }

    @RequestMapping(value = "/search/phone/{number}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<DriverData> findByNumberPhone(@PathVariable("number") String number) {
        if (number == null) {
            throw new BadRequestException("Неверный запрос. Номер телефона не может быть:" + number);
        }

        DriverData driverData = driverDataService.findByField("numberphone", number);
        if (driverData == null) {
            throw new EntityNotFoundException("Водителя с номером телефона: " + number + " не найдено в базе данных");
        }

        return new ResponseEntity<>(driverData, HttpStatus.OK);
    }

    @RequestMapping(value = "/search/company/{name}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<DriverData>> findByCompany(@PathVariable String name) {
        if (name == null) {
            throw new BadRequestException("Неверный запрос. Компания не может быть: " + name);
        }
        List<DriverData> driverDatas = driverDataService.findAllField();
        for (DriverData driverData : driverDatas) {
            if (driverData.getCompany().getName().equals(name)) {
                driverDataList.add(driverData);
            }
        }
        if (driverDataList.isEmpty()) {
            throw new EntityNotFoundException("Водителя компании " + name + " не найдено в базе данных");
        }

        return new ResponseEntity<>(driverDataList, HttpStatus.OK);
    }

    @Override
    public AbstractService getService() {
        return driverDataService;
    }
}
