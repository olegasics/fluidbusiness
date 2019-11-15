package ru.basics.server.repository.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.basics.server.entity.DriverData;

@Service
@Transactional
public class DriverDataDAO extends AbstractDAO<DriverData> {
    @Override
    public Class<DriverData> getEntityClass() {
        return DriverData.class;
    }
}
