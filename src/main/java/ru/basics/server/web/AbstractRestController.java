package ru.basics.server.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.basics.server.entity.CargoMove;
import ru.basics.server.repository.dao.AbstractDAO;
import javax.validation.Valid;
import java.util.List;

@RestController
public abstract class AbstractRestController<T> {

    public abstract AbstractDAO getDao();

    final static Logger logger = LoggerFactory.getLogger(UserRestController.class);


    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> add(@RequestBody @Valid T t) {
        if (t == null) {
            logger.info("WARNING: Entity is not added ... BAD_REQUEST in method /add {}", t);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

        getDao().create(t);
        logger.info("OK: Entity added in DB in method /add " + t);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.GET)
    public List<T> all() {
        logger.info("OK: Return all entity in method /all");
        return (List<T>) getDao().findAllField();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> getById(@PathVariable Long id) {
        T t = (T) getDao().findById(id);
        if (t == null) {
            logger.info("WARNING: entity with id {} dos't exist ", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> updateEntity(@RequestBody @Valid T t) {
        if (t == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!getDao().isExist(t)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        getDao().update(t);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> deleteById(@PathVariable Long id) {
        T t = (T) getDao().findById(id);
        if(t == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        getDao().delete(t);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
