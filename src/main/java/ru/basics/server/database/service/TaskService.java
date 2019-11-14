package ru.basics.server.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basics.server.database.dao.AbstractDAO;
import ru.basics.server.database.dao.TaskDAO;
import ru.basics.server.database.entity.Task;

import javax.transaction.Transactional;

@Service
@Transactional
public class TaskService extends AbstractService<Task> {
    @Autowired
    TaskDAO taskDAO;

    @Override
    public AbstractDAO getDao() {
        return taskDAO;
    }


}
