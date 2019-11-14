package ru.basics.server.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.basics.server.database.dao.AbstractDAO;
import ru.basics.server.database.dao.WaybillDocumentDAO;
import ru.basics.server.database.entity.WaybillDocument;

public class WaybillDocumentService extends AbstractService<WaybillDocument> {
    @Autowired
    WaybillDocumentDAO waybillDocumentDAO;

    @Override
    public AbstractDAO getDao() {
        return waybillDocumentDAO;
    }


}
