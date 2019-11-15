package ru.basics.server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.repository.dao.AbstractDAO;
import ru.basics.server.repository.dao.TaskDAO;
import ru.basics.server.entity.Task;

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
