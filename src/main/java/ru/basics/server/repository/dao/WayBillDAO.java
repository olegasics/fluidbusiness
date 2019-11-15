package ru.basics.server.repository.dao;

import org.springframework.stereotype.Service;
import ru.basics.server.entity.Waybill;

import javax.transaction.Transactional;

@Service
@Transactional
public class WayBillDAO extends AbstractDAO<Waybill> {
    @Override
    public Class<Waybill> getEntityClass() {
        return Waybill.class;
    }
}
