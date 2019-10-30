package ru.basics.server.database.dao;

import ru.basics.server.database.entity.Task;

public class TaskDAO extends AbstractDAO<Task> {
    @Override
    public Class<Task> getEntityClass() {
        return Task.class;
    }
}
