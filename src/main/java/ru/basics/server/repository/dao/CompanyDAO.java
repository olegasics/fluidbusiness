package ru.basics.server.repository.dao;

import org.springframework.stereotype.Service;
import ru.basics.server.entity.Company;

import javax.transaction.Transactional;

@Service
@Transactional
public class CompanyDAO extends AbstractDAO<Company> {
    @Override
    public Class<Company> getEntityClass() {
        return Company.class;
    }
}
