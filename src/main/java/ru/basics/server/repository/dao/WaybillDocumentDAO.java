package ru.basics.server.repository.dao;

import org.springframework.stereotype.Service;
import ru.basics.server.entity.WaybillDocument;

import javax.transaction.Transactional;

@Service
@Transactional
public class WaybillDocumentDAO extends AbstractDAO<WaybillDocument> {
    @Override
    public Class<WaybillDocument> getEntityClass() {
        return WaybillDocument.class;
    }
}
