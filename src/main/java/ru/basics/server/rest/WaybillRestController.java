package ru.basics.server.rest;

import org.springframework.http.ResponseEntity;
import ru.basics.server.database.entity.WaybillDocument;

import java.util.List;

public class WaybillRestController implements RestControllerInterface<WaybillDocument> {
    @Override
    public ResponseEntity<WaybillDocument> add(WaybillDocument waybillDocument) {
        return null;
    }

    @Override
    public ResponseEntity<List<WaybillDocument>> all() {
        return null;
    }

    @Override
    public ResponseEntity<WaybillDocument> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<WaybillDocument> update(WaybillDocument waybillDocument) {
        return null;
    }

    @Override
    public ResponseEntity<WaybillDocument> delete(WaybillDocument waybillDocument) {
        return null;
    }

    @Override
    public ResponseEntity<WaybillDocument> deleteById(Long id) {
        return null;
    }
}
