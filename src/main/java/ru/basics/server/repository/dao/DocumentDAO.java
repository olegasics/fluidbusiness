package ru.basics.server.repository.dao;

import org.springframework.stereotype.Service;
import ru.basics.server.entity.Document;

import javax.transaction.Transactional;

@Service
@Transactional
public class DocumentDAO extends AbstractDAO<Document> {
    @Override
    public Class<Document> getEntityClass() {
        return Document.class;
    }
}
