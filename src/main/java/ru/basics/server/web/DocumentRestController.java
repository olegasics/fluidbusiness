package ru.basics.server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.repository.dao.AbstractDAO;
import ru.basics.server.repository.dao.DocumentDAO;
import ru.basics.server.entity.Company;
import ru.basics.server.entity.Document;
import ru.basics.server.entity.Project;
import ru.basics.server.service.AbstractService;
import ru.basics.server.service.DocumentService;

import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentRestController extends AbstractRestController<Document> {
    DocumentService documentService;
    List<Document> documents;

    @Autowired
    public DocumentRestController(DocumentService documentService) {
        this.documentService = documentService;
    }

    public DocumentRestController() {
    }

    @RequestMapping(value = "/search/project", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Document> findByProject(Project project) {
        if (project == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Document document = documentService.findByField("numProject", project);
        if (document == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(document, HttpStatus.OK);
    }

    @RequestMapping(value = "/search/company", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Document>> findByCompany(Company company) {
        if (company == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Document document = documentService.findByField("company", company);
        if (document == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        do {
            documents.add(document);
            document = documentService.findByField("company", company);
        } while (document != null);

        return new ResponseEntity<>(documents, HttpStatus.OK);
    }

    @RequestMapping(value = "/search{name}")
    public ResponseEntity<Document> findByCompany(@PathVariable("name") String name) {
        if (name == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Document document = documentService.findByField("name", name);
        if (document == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(document, HttpStatus.OK);
    }

    @Override
    public AbstractService getService() {
        return documentService;
    }
}
