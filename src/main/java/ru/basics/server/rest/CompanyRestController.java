package ru.basics.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.database.dao.AbstractDAO;
import ru.basics.server.database.dao.CompanyDAO;
import ru.basics.server.database.entity.Company;

@RestController
@RequestMapping("/companies")
public class CompanyRestController extends AbstractRestController<Company> {

    CompanyDAO companyDAO;

    @Autowired
    public CompanyRestController(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    public CompanyRestController() {
    }

    @Override
    public AbstractDAO getDao() {
        return companyDAO;
    }

}
