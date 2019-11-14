package ru.basics.server.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basics.server.database.dao.AbstractDAO;
import ru.basics.server.database.dao.CompanyDAO;
import ru.basics.server.database.entity.Company;

import javax.transaction.Transactional;

@Service
@Transactional
public class CompanyService extends AbstractService<Company> {

    @Autowired
    CompanyDAO companyDAO;

    @Override
    public AbstractDAO getDao() {
        return companyDAO;
    }


}
