package ru.basics.server.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.repository.dao.AbstractDAO;
import ru.basics.server.repository.dao.TaskDAO;
import ru.basics.server.entity.Task;
import ru.basics.server.service.AbstractService;
import ru.basics.server.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskRestController extends AbstractRestController<Task> {

    TaskService taskService;

    @Autowired
    public TaskRestController(TaskService taskService) {
        this.taskService = taskService;
    }

    public TaskRestController() {
    }

    @Override
    public Logger getLogger() {
        return LoggerFactory.getLogger(TaskRestController.class);
    }

    @Override
    public AbstractService getService() {
        return taskService;
    }
}
