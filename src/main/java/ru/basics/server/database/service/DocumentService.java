package ru.basics.server.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basics.server.database.dao.AbstractDAO;
import ru.basics.server.database.dao.DocumentDAO;
import ru.basics.server.database.entity.Document;

import javax.transaction.Transactional;

@Service
@Transactional
public class DocumentService extends AbstractService<Document> {
    @Autowired
    DocumentDAO documentDAO;

    @Override
    public AbstractDAO getDao() {
        return documentDAO;
    }


}
