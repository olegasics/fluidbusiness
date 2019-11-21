package ru.basics.server.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.entity.Company;
import ru.basics.server.entity.Document;
import ru.basics.server.entity.Project;
import ru.basics.server.repository.exceptions.BadRequestException;
import ru.basics.server.repository.exceptions.EntityNotFoundException;
import ru.basics.server.service.AbstractService;
import ru.basics.server.service.CompanyService;
import ru.basics.server.service.DocumentService;
import ru.basics.server.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentRestController extends AbstractRestController<Document> {
    DocumentService documentService;
    List<Document> documents;
    ProjectService projectService;
    CompanyService companyService;

    @Autowired
    public DocumentRestController(DocumentService documentService, ProjectService projectService, CompanyService companyService ) {
        this.documentService = documentService;
        this.projectService = projectService;
        this.companyService = companyService;
    }

    public DocumentRestController() {
    }

    @Override
    public Logger getLogger() {
        return LoggerFactory.getLogger(DocumentRestController.class);
    }

    @RequestMapping(value = "/search/project{numProject}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Document> findByProject(@PathVariable String numProject) {
        if (numProject == null) {
            getLogger().warn("Bad request in method /findByProject");
            throw new BadRequestException("Неверный запрос. Проект не может быть: " + numProject);
        }
        Project project = projectService.findByField("name", numProject);
        Document document = documentService.findByField("numProject", project);
        if (document == null) {
            getLogger().warn("Document with project - {} not found, in method /findByProject", project);
            throw new EntityNotFoundException("Документа с номером проекта: " + numProject + " не найдено в базе данных");
        }

        return new ResponseEntity<>(document, HttpStatus.OK);
    }

    @RequestMapping(value = "/search/company/{name}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Document>> findByCompanyName(@PathVariable String name) {
        if (name == null) {
            getLogger().warn("Bad request in method /findByCompany");
            throw new BadRequestException("Неверный запрос. Компания не может быть: " + name);

        }
        Company company = companyService.findByField("name", name);
        List<Document> documentsBySearch = documentService.findAllField();
        for(Document document : documentsBySearch) {
            if(document.getName() == name) {
                documents.add(document);
            }
        }
        if (documents.isEmpty()) {
            throw new EntityNotFoundException("Документа пренадлежащий компании: " + name + " не найдено в базе данных");
        }

        return new ResponseEntity<>(documents, HttpStatus.OK);
    }

    @Override
    public AbstractService getService() {
        return documentService;
    }
}
