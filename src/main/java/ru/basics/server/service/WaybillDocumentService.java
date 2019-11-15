package ru.basics.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basics.server.repository.dao.AbstractDAO;
import ru.basics.server.repository.dao.WaybillDocumentDAO;
import ru.basics.server.entity.WaybillDocument;

import javax.transaction.Transactional;

@Service
@Transactional
public class WaybillDocumentService extends AbstractService<WaybillDocument> {
    @Autowired
    WaybillDocumentDAO waybillDocumentDAO;

    @Override
    public AbstractDAO getDao() {
        return waybillDocumentDAO;
    }


}
