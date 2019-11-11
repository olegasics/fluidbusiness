package ru.basics.server.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.basics.server.database.dao.AbstractDAO;
import ru.basics.server.database.dao.TestDAO;
import ru.basics.server.database.entity.AbstractStandartEntity;
import ru.basics.server.database.entity.CargoMove;
import ru.basics.server.database.entity.Project;
import ru.basics.server.utils.restUtils.RestUtils;

import javax.validation.Valid;
import java.util.List;

public class RestControllerInterface<T extends Project> extends AbstractDAO<T> {


    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> add(@RequestBody @Valid T t) {
        if (t == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.create(t);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    public ResponseEntity<List<T>> all() {
        return new ResponseEntity<>(this.findAllField(), HttpStatus.OK);
    }

    public ResponseEntity<T> getById(Long id) {
        T t = this.findById(id);

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

//        if(!this.isExist(project.getNumber())) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        this.update(t);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }


    @Override
    public Class<T> getEntityClass() {
        return null;
    }
/*
    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.GET)
    public ResponseEntity<List<T>> all();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> getById(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> update(@RequestBody @Valid T t);

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> delete(@RequestBody @Valid T t);

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> deleteById(@PathVariable("id") Long id);
    */


}
