package ru.basics.server.web;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.basics.server.repository.exceptions.BadRequestException;
import ru.basics.server.repository.exceptions.EntityNotFoundException;
import ru.basics.server.repository.exceptions.HibernateDBException;
import ru.basics.server.service.AbstractService;

import javax.validation.Valid;
import java.util.List;

@RestController
@jdk.nashorn.internal.runtime.logging.Logger
public abstract class AbstractRestController<T> {

    public abstract AbstractService getService();

    public abstract Logger getLogger();

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> add(@RequestBody @Valid T t) {
        if (t == null) {
            getLogger().warn("Entity is not added ... BAD_REQUEST in method /add");
            throw new BadRequestException();
        }
        try {
            getService().create(t);
            getLogger().info("Создана новая сущность в базе данных, метод /add " + t);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (HibernateException e) {
            System.out.println(e);
//            getLogger().error("Ошибка при создании сущности в базе данных. Создавая сущность: {}. Метод /add", t);
           throw new HibernateDBException(e.getMessage());
        }
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.GET)
    public List<T> all() {
        return getService().findAllField();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> getById(@PathVariable Long id) {
        T t = (T) getService().findById(id);
        if (t == null) {
            getLogger().warn("Entity with id {} not found ", id);
            throw new EntityNotFoundException(id);
        }
        getLogger().info("Найдена сущность в базе данных с id={}", id);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> update(@PathVariable Long id) {
        T t = (T) getService().findById(id);
        if (t == null) {
            getLogger().warn("Entity: {} not found in method /update", t);
            throw new EntityNotFoundException(id);
        }

        getService().update(t);
        getLogger().info("Entity: {} successful updated", t);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> deleteById(@PathVariable Long id) {
        T t = (T) getService().findById(id);
        if (t == null) {
            getLogger().warn("Entity is not deleted ... BAD_REQUEST in method /deleteById");
            throw new EntityNotFoundException(id);
        }
        getService().delete(t);
        getLogger().info("Entity {} successful deleted", t);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
