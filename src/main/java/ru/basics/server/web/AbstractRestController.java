package ru.basics.server.web;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.basics.server.service.AbstractService;

import javax.validation.Valid;
import java.util.List;

@RestController
public abstract class AbstractRestController<T> {

    public abstract AbstractService getService();

    public abstract Logger getLogger();

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> add(@RequestBody @Valid T t) {
        if (t == null) {
            getLogger().warn("Entity is not added ... BAD_REQUEST in method /add");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        getService().create(t);
        getLogger().info("Entity added in DB in method /add " + t);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.GET)
    public void all() {
        try {
            //getLogger().info("Return all entity in method /all");
            throw new Exception();
            // return (List<T>) getService().findAllField();
        } catch (Exception e) {
            getLogger().info("Return all entity in method /all");
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> getById(@PathVariable Long id) {
        T t = (T) getService().findById(id);
        if (t == null) {
            getLogger().warn("Entity with id {} not found ", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> update(@RequestBody @Valid T t) {
        if (t == null) {
            getLogger().warn("Bad request in method /update");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!getService().isExist(t)) {
            getLogger().warn("Entity: {} not found in method /update", t);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        getService().update(t);
        getLogger().info("Entity: {} successful updated", t);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> deleteById(@PathVariable Long id) {
        T t = (T) getService().findById(id);
        if(t == null) {
            getLogger().warn("Entity is not deleted ... BAD_REQUEST in method /deleteById");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        getService().delete(t);
        getLogger().info("Entity {} is deleted", t);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
