package ru.basics.server.database.dao;

import org.springframework.stereotype.Service;
import ru.basics.server.database.entity.Company;

import javax.transaction.Transactional;

@Service
@Transactional
public class CompanyDAO extends AbstractDAO<Company> {
    @Override
    public Class<Company> getEntityClass() {
        return Company.class;
    }
}
