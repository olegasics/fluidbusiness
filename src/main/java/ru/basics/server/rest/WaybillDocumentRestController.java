package ru.basics.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.database.dao.WaybillDocumentDAO;
import ru.basics.server.database.entity.WaybillDocument;
import java.util.List;

@RestController
@RequestMapping(value = "/waybills-documents")
public class WaybillDocumentRestController implements RestControllerInterface<WaybillDocument> {

    WaybillDocumentDAO waybillDocumentDAO;

    @Autowired
    public WaybillDocumentRestController(WaybillDocumentDAO waybillDocumentDAO) {
        this.waybillDocumentDAO = waybillDocumentDAO;
    }

    public WaybillDocumentRestController() {
    }

    @Override
    public ResponseEntity<WaybillDocument> add(WaybillDocument waybillDocument) {
        if (waybillDocument == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        waybillDocumentDAO.create(waybillDocument);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<WaybillDocument>> all() {
        List<WaybillDocument> waybillDocuments = waybillDocumentDAO.findAllField();
        return new ResponseEntity<>(waybillDocuments, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<WaybillDocument> getById(Long id) {
        WaybillDocument waybillDocuments = waybillDocumentDAO.findById(id);
        if (waybillDocuments == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(waybillDocuments, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<WaybillDocument> update(WaybillDocument waybillDocument) {
        if (waybillDocument == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        waybillDocumentDAO.update(waybillDocument);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<WaybillDocument> delete(WaybillDocument waybillDocument) {
        if (waybillDocument == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (waybillDocumentDAO.findById(waybillDocument.getId()) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        waybillDocumentDAO.delete(waybillDocument);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<WaybillDocument> deleteById(Long id) {
        WaybillDocument waybillDocument = waybillDocumentDAO.findById(id);
        if (waybillDocument == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        waybillDocumentDAO.delete(waybillDocument);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
