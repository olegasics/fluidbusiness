package ru.basics.server.web;

import org.hibernate.HibernateException;
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
import ru.basics.server.repository.dao.*;
import ru.basics.server.entity.*;
import ru.basics.server.repository.exceptions.BadRequestException;
import ru.basics.server.repository.exceptions.EntityNotFoundException;
import ru.basics.server.repository.exceptions.HibernateDBException;
import ru.basics.server.service.AbstractService;
import ru.basics.server.service.CargoMoveService;
import ru.basics.server.service.DocumentService;
import ru.basics.server.service.WaybillService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cargo-moves")
public class CargoMoveRestController extends AbstractRestController<CargoMove> {

    CargoMoveDAO cargoMoveDAO;
    WaybillService waybillService;
    DocumentService documentService;
    List<CargoMove> cargoMoves;
    CargoMoveService cargoMoveService;

    @Autowired
    public CargoMoveRestController(CargoMoveDAO cargoMoveDAO, WaybillService waybillService, DocumentService documentService,
                                   CargoMoveService cargoMoveService) {
        this.cargoMoveDAO = cargoMoveDAO;
        this.waybillService = waybillService;
        this.documentService = documentService;
        this.cargoMoveService = cargoMoveService;
    }

    public CargoMoveRestController() {
    }

    @Override
    public Logger getLogger() {
        return LoggerFactory.getLogger(CargoMoveRestController.class);
    }

    @Override
    public Class<CargoMove> getEntityClass() {
        return CargoMove.class;
    }

    /*
    public ResponseEntity<CargoMove> update(Long id, @PathVariable CargoMove cargoMove) {
        CargoMove cargoMoveTemp = cargoMoveService.findById(id);
        if(cargoMove == null) {
            getLogger().warn("Entity: {} not found in method /update", id);
            throw new EntityNotFoundException(id);
        }
        getService().update(cargoMove);
        getLogger().info("Entity: {} successful updated", cargoMove);
        return new ResponseEntity<>(cargoMove, HttpStatus.OK);
    }

     */

    @RequestMapping(value = "/search/waybills/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<CargoMove>> findByWaybill(@PathVariable("id") Long number) {
        List<CargoMove> cargoMoves = new ArrayList<>();
        if (number == null) {
            getLogger().warn("Bad request in method /findByWaybill");
            throw new BadRequestException();
        }
        Waybill waybill = waybillService.findByField("number", number);
        if (waybill == null) {
            getLogger().warn("Waybill № {} not found, method /findByWaybill", number);
            throw new EntityNotFoundException(number);
        }

        CargoMove cargoMove = cargoMoveService.findByField("waybill", waybill);
        if (cargoMove == null) {
            getLogger().warn("Cargo with WayBill_id - {} not found, method /findByWaybill", number);
            throw new EntityNotFoundException(waybill.getId());
        }
        try {
            cargoMoves.add(cargoMove);
            return new ResponseEntity<>(cargoMoves, HttpStatus.OK);
        } catch (HibernateException e) {
            throw new HibernateDBException(e.getMessage());
        }
    }

    @RequestMapping(value = "/search/invoice/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<CargoMove>> findByInvoice(@PathVariable("id") String documentNumber) {
        if (documentNumber == null) {
            getLogger().warn("Bad request in method /findByInvoice");
            throw new BadRequestException("Неверный запрос. Передаваемый номер счета: " + documentNumber);
        }
        Document document = documentService.findByField("name", documentNumber);
        if (document == null) {
            getLogger().warn("Invoice № {} not found, method /findByInvoice", documentNumber);
            throw new EntityNotFoundException(documentNumber);
        }
        List<CargoMove> cargoMovesForSearch = cargoMoveService.findAllField();
        for (CargoMove cargoMove : cargoMovesForSearch) {
            if (cargoMove.getWaybillDocuments().get(0).getDocument().getName().equals(documentNumber)) {
                cargoMoves.add(cargoMove);
            }
        }
        if (cargoMoves.isEmpty()) {
            getLogger().warn("Invoice № {} not found, method /findByInvoice", documentNumber);
            throw new EntityNotFoundException("Записи счетом № " + documentNumber + " нет в таблице");
        }

        return new ResponseEntity<>(cargoMoves, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/search/track-number/{track}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CargoMove> findByTrackNumber(@PathVariable("track") String trackNumber) {
        if (trackNumber == null) {
            getLogger().warn("Bad request in method /findByTrackNumber");
            throw new BadRequestException("Неверный запрос. Передаваемый трек номер: " + trackNumber);
        }

        CargoMove cargoMove = cargoMoveService.findByField("tracknumber", trackNumber);
        if (cargoMove == null) {
            getLogger().warn("Cargo with track number - {} not found, in method /findByTrackNumber", trackNumber);
            throw new EntityNotFoundException("Записи с трек номером: " + trackNumber + " нет в таблице");
        }

        return new ResponseEntity<>(cargoMove, HttpStatus.OK);
    }

    @Override
    public AbstractService getService() {
        return cargoMoveService;
    }
}
