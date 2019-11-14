package ru.basics.server.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.basics.server.database.dao.AbstractDAO;
import ru.basics.server.database.dao.TaskDAO;
import ru.basics.server.database.entity.Task;

public class TaskService extends AbstractService<Task> {
    @Autowired
    TaskDAO taskDAO;

    @Override
    public AbstractDAO getDao() {
        return taskDAO;
    }


}
