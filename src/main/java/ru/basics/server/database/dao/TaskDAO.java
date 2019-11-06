package ru.basics.server.database.dao;

import org.springframework.stereotype.Service;
import ru.basics.server.database.entity.Task;

import javax.transaction.Transactional;

@Service
@Transactional
public class TaskDAO extends AbstractDAO<Task> {
    @Override
    public Class<Task> getEntityClass() {
        return Task.class;
    }
}
