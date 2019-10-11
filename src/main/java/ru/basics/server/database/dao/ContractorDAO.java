package ru.basics.server.database.dao;

import ru.basics.server.database.entity.AbstractPerson;

public class ContractorDAO extends AbstractDAO<AbstractPerson> {
    @Override
    public Class<AbstractPerson> getEntityClass() {
        return AbstractPerson.class;
    }
}
