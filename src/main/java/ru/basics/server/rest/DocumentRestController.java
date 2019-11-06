package ru.basics.server.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.basics.server.database.dao.DocumentDAO;
import ru.basics.server.database.entity.CargoMove;
import ru.basics.server.database.entity.Document;

import javax.print.Doc;
import java.util.List;

public class DocumentRestController implements RestController<Document> {
    DocumentDAO documentDAO;

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
