package ru.basics.server.database.dao;

import com.sun.istack.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.basics.server.database.entity.AbstractPerson;
import ru.basics.server.database.entity.Contractor;

public class ContractorDAO extends AbstractDAO<AbstractPerson> {
    @Override
    public Class<AbstractPerson> getEntityClass() {
        return AbstractPerson.class;
    }
}
