package ru.basics.server.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.basics.server.database.dao.AbstractDAO;
import ru.basics.server.database.dao.CompanyDAO;
import ru.basics.server.database.entity.Company;

public class CompanyService extends AbstractService<Company> {

    @Autowired
    CompanyDAO companyDAO;

    @Override
    public AbstractDAO getDao() {
        return companyDAO;
    }


}
