package ru.basics.server.web;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.entity.WaybillDocument;
import ru.basics.server.repository.exceptions.BadRequestException;
import ru.basics.server.repository.exceptions.EntityNotFoundException;
import ru.basics.server.repository.exceptions.HibernateDBException;
import ru.basics.server.service.AbstractService;
import ru.basics.server.service.WaybillDocumentService;

import java.util.List;

@RestController
@RequestMapping(value = "/waybills-documents")
public class WaybillDocumentRestController extends AbstractRestController<WaybillDocument> {

    WaybillDocumentService waybillDocumentService;
    List<WaybillDocument> waybillDocumentList;

    @Autowired
    public WaybillDocumentRestController(WaybillDocumentService waybillDocumentService) {
        this.waybillDocumentService = waybillDocumentService;
    }

    public WaybillDocumentRestController() {
    }

    @Override
    public Logger getLogger() {
        return LoggerFactory.getLogger(WaybillDocumentRestController.class);
    }

    @Override
    public Class<WaybillDocument> getEntityClass() {
        return WaybillDocument.class;
    }

    @RequestMapping(value = "/search/item/{item}")
    public ResponseEntity<List<WaybillDocument>> searchByItem(@PathVariable String item) {
        if(item == null) {
            getLogger().warn("Неверный запрос в методе /searchByItem. Передаваемое значение не может быть {}", item);
            throw new BadRequestException("Неверный запрос. ... не может быть: " + item);
        }
        List<WaybillDocument> waybillDocuments = null;
        try {
            waybillDocuments = waybillDocumentService.findAllField();
        } catch (HibernateException e) {
            throw new HibernateDBException(e.getMessage());
        }
        if(!waybillDocuments.isEmpty()) {
            for(WaybillDocument waybillDocument : waybillDocuments) {
                if(waybillDocument.getItem().equals(item)) {
                    waybillDocumentList.add(waybillDocument);
                }
            }
        }

        if(waybillDocumentList.isEmpty()) {
            getLogger().warn("ТТН с позицией {} не найдена в базе данных, метод /searchByItem", item);
            throw new EntityNotFoundException("ТТН с позицией: " + item + " не найдена в базе данных");
        }

        return new ResponseEntity<>(waybillDocumentList, HttpStatus.OK);
    }

    @Override
    public AbstractService<WaybillDocument> getService() {
        return waybillDocumentService;
    }

}
