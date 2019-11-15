package ru.basics.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basics.server.repository.dao.AbstractDAO;
import ru.basics.server.repository.dao.TaskDAO;
import ru.basics.server.entity.Task;

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
