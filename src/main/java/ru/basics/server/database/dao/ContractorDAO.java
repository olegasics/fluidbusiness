package ru.basics.server.database.dao;

import ru.basics.server.database.entity.Company;

public class ContractorDAO extends AbstractDAO<Company> {
    @Override
    public Class<Company> getEntityClass() {
        return Company.class;
    }
}
