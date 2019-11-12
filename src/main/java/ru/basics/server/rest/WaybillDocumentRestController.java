package ru.basics.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.database.dao.AbstractDAO;
import ru.basics.server.database.dao.WaybillDocumentDAO;
import ru.basics.server.database.entity.WaybillDocument;

@RestController
@RequestMapping(value = "/waybills-documents")
public class WaybillDocumentRestController extends AbstractRestController<WaybillDocument> {

    WaybillDocumentDAO waybillDocumentDAO;

    @Autowired
    public WaybillDocumentRestController(WaybillDocumentDAO waybillDocumentDAO) {
        this.waybillDocumentDAO = waybillDocumentDAO;
    }

    public WaybillDocumentRestController() {
    }

    @Override
    public AbstractDAO getDao() {
        return waybillDocumentDAO;
    }

}
