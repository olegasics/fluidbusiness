package ru.basics.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.database.dao.AbstractDAO;
import ru.basics.server.database.dao.DriverDataDAO;
import ru.basics.server.database.entity.DriverData;

@RestController
@RequestMapping("/drivers")
public class DriverDataRestController extends AbstractRestController<DriverData> {
    DriverDataDAO driverDataDAO;

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
}
