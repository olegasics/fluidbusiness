package ru.basics.server.database.dao;

import ru.basics.server.database.entity.Document;

public class DocumentDAO extends AbstractDAO<Document> {
    @Override
    public Class<Document> getEntityClass() {
        return Document.class;
    }
}
