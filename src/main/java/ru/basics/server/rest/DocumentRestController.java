package ru.basics.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.database.dao.DocumentDAO;
import ru.basics.server.database.entity.Document;

import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentRestController implements RestControllerInterface<Document> {
    DocumentDAO documentDAO;

    @Autowired
    public DocumentRestController(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    public DocumentRestController() {
    }

    @Override
    public ResponseEntity<Document> add(Document document) {
        if(document == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        documentDAO.create(document);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<Document>> all() {
        List<Document> documents = documentDAO.findAllField();
        return new ResponseEntity<>(documents, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Document> getById(Long id) {
        Document document = documentDAO.findById(id);
        if(document == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(document, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Document> update(Document document) {
        if(document == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        documentDAO.update(document);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Document> delete(Document document) {
        if(document == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(documentDAO.findById(document.getId()) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        documentDAO.delete(document);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Document> deleteById(Long id) {
        Document document = documentDAO.findById(id);
        if(document == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        documentDAO.delete(document);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
