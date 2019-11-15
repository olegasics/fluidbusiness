package ru.basics.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basics.server.repository.dao.AbstractDAO;
import ru.basics.server.repository.dao.DocumentDAO;
import ru.basics.server.entity.Document;

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
