package ru.basics.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.database.dao.AbstractDAO;
import ru.basics.server.database.dao.TaskDAO;
import ru.basics.server.database.entity.Task;

@RestController
@RequestMapping("/tasks")
public class TaskRestController extends AbstractRestController<Task> {

    TaskDAO taskDAO;

    @Autowired
    public TaskRestController(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public TaskRestController() {
    }

    @Override
    public AbstractDAO getDao() {
        return taskDAO;
    }
}
