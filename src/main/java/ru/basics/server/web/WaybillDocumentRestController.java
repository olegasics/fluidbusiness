package ru.basics.server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.repository.dao.AbstractDAO;
import ru.basics.server.repository.dao.WaybillDocumentDAO;
import ru.basics.server.entity.WaybillDocument;
import ru.basics.server.service.AbstractService;
import ru.basics.server.service.WaybillDocumentService;

@RestController
@RequestMapping(value = "/waybills-documents")
public class WaybillDocumentRestController extends AbstractRestController<WaybillDocument> {

    WaybillDocumentService waybillDocumentService;

    @Autowired
    public WaybillDocumentRestController(WaybillDocumentService waybillDocumentService) {
        this.waybillDocumentService = waybillDocumentService;
    }

    public WaybillDocumentRestController() {
    }

    @Override
    public AbstractService<WaybillDocument> getService() {
        return waybillDocumentService;
    }

}
