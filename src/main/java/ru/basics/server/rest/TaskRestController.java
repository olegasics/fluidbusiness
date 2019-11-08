package ru.basics.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.database.dao.TaskDAO;
import ru.basics.server.database.entity.Task;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskRestController implements RestControllerInterface<Task> {

    TaskDAO taskDAO;

    @Autowired
    public TaskRestController(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public TaskRestController() {
    }

    @Override
    public ResponseEntity<Task> add(Task task) {
        if (task == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        taskDAO.create(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Task>> all() {
        List<Task> tasks = taskDAO.findAllField();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Task> getById(Long id) {
        Task task = taskDAO.findById(id);
        if (task == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Task> update(Task task) {
        if (task == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        taskDAO.update(task);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Task> delete(Task task) {
        if (task == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (taskDAO.findById(task.getId()) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        taskDAO.delete(task);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Task> deleteById(Long id) {
        Task task = taskDAO.findById(id);
        if (task == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        taskDAO.delete(task);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
