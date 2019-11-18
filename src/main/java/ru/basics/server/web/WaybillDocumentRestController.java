package ru.basics.server.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.repository.dao.AbstractDAO;
import ru.basics.server.repository.dao.WaybillDocumentDAO;
import ru.basics.server.entity.WaybillDocument;
import ru.basics.server.service.AbstractService;
import ru.basics.server.service.WaybillDocumentService;

import java.util.List;

@RestController
@RequestMapping(value = "/waybills-documents")
public class WaybillDocumentRestController extends AbstractRestController<WaybillDocument> {

    WaybillDocumentService waybillDocumentService;
    List<WaybillDocument> waybillDocumentList;

    @Autowired
    public WaybillDocumentRestController(WaybillDocumentService waybillDocumentService) {
        this.waybillDocumentService = waybillDocumentService;
    }

    public WaybillDocumentRestController() {
    }

    @Override
    public Logger getLogger() {
        return LoggerFactory.getLogger(WaybillDocumentRestController.class);
    }

    @RequestMapping(value = "/search/item/{item}")
    public ResponseEntity<List<WaybillDocument>> searchByItem(@PathVariable String item) {
        if(item == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<WaybillDocument> waybillDocuments = waybillDocumentService.findAllField();
        if(!waybillDocuments.isEmpty()) {
            for(WaybillDocument waybillDocument : waybillDocuments) {
                if(waybillDocument.getItem().equals(item)) {
                    waybillDocumentList.add(waybillDocument);
                }
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(waybillDocumentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(waybillDocumentList, HttpStatus.OK);
    }

    @Override
    public AbstractService<WaybillDocument> getService() {
        return waybillDocumentService;
    }

}
