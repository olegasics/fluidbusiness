package ru.basics.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.basics.server.database.dao.CargoMoveDAO;
import ru.basics.server.database.entity.CargoMove;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/cargro-moves")
public class CargoMoveRestControllerInterface implements RestControllerInterface<CargoMove> {

    CargoMoveDAO cargoMoveDAO;

    @Autowired
    public CargoMoveRestControllerInterface(CargoMoveDAO cargoMoveDAO) {
        this.cargoMoveDAO = cargoMoveDAO;
    }

    public CargoMoveRestControllerInterface() {
    }

    @Override
    public ResponseEntity<CargoMove> add(CargoMove cargoMove) {
        if(cargoMove == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        cargoMoveDAO.create(cargoMove);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<CargoMove>> all() {
        return new ResponseEntity<>(cargoMoveDAO.findAllField(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CargoMove> getById(Long id) {
        CargoMove cargoMove = cargoMoveDAO.findById(id);
        if(cargoMove == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(cargoMove, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CargoMove> update(CargoMove cargoMove) {
        if(cargoMove == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        cargoMoveDAO.update(cargoMove);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<CargoMove> delete(CargoMove cargoMove) {
        if(cargoMove == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(cargoMoveDAO.findById(cargoMove.getId()) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        cargoMoveDAO.delete(cargoMove);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<CargoMove> deleteById(Long id) {
        CargoMove cargoMove = cargoMoveDAO.findById(id);
        if(cargoMove == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        cargoMoveDAO.delete(cargoMove);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
