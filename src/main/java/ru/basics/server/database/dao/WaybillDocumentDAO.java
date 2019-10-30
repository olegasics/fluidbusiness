package ru.basics.server.database.dao;

import ru.basics.server.database.entity.WaybillDocument;

public class WaybillDocumentDAO extends AbstractDAO<WaybillDocument> {
    @Override
    public Class<WaybillDocument> getEntityClass() {
        return WaybillDocument.class;
    }
}
