package ru.basics.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.database.dao.AbstractDAO;
import ru.basics.server.database.dao.DocumentDAO;
import ru.basics.server.database.entity.Document;

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

}
