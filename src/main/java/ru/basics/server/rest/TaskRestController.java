package ru.basics.server.rest;

import org.springframework.http.ResponseEntity;
import ru.basics.server.database.entity.Task;

import java.util.List;

public class TaskRestController implements RestControllerInterface<Task> {
    @Override
    public ResponseEntity<Task> add(Task task) {
        return null;
    }

    @Override
    public ResponseEntity<List<Task>> all() {
        return null;
    }

    @Override
    public ResponseEntity<Task> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Task> update(Task task) {
        return null;
    }

    @Override
    public ResponseEntity<Task> delete(Task task) {
        return null;
    }

    @Override
    public ResponseEntity<Task> deleteById(Long id) {
        return null;
    }
}
