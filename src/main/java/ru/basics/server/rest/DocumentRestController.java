package ru.basics.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.database.dao.AbstractDAO;
import ru.basics.server.database.dao.DocumentDAO;
import ru.basics.server.database.entity.Document;
import ru.basics.server.database.entity.Project;
import ru.basics.server.database.exceptions.BadRequestExceprion;

@RestController
@RequestMapping("/documents")
public class DocumentRestController extends AbstractRestController<Document> {
    DocumentDAO documentDAO;

    @Autowired
    public DocumentRestController(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    public DocumentRestController() {
    }

    @Override
    public AbstractDAO getDao() {
        return documentDAO;
    }

    @RequestMapping(value = "/project", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Document> findByProject(Project project) {
        if (project == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Document document = documentDAO.findByField("numProject", project);
        if (document == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(document, HttpStatus.OK);
    }

}
