package ru.basics.server.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.basics.server.database.entity.Project;
import ru.basics.server.database.entity.User;

import javax.validation.Valid;
import java.util.List;

public interface RestControllerInterface<T> {

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> add(@RequestBody @Valid T t);
    //public ResponseEntity<T> login(@PathVariable("id") Long id);

    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.GET)
    public ResponseEntity<List<T>> all();

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> getById(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> update(@RequestBody @Valid T t);

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> delete(@RequestBody @Valid T t);

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> deleteById(@PathVariable("id") Long id);

}
