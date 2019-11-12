package ru.basics.server.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.basics.server.database.dao.AbstractDAO;
import javax.validation.Valid;
import java.util.List;

public abstract class AbstractRestController<T> {

    public abstract AbstractDAO getDao();

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> add(@RequestBody @Valid T t) {
        if (t == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        getDao().create(t);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.GET)
    public List<T> all() {
        return (List<T>) getDao().findAllField();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> getById(Long id) {
        T t = (T) getDao().findById(id);
        if (t == null) {
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
    public ResponseEntity<T> deleteById(Long id) {
        T t = (T) getDao().findById(id);
        if(t == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        getDao().delete(t);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
