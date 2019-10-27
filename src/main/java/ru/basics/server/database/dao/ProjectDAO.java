package ru.basics.server.database.dao;

import ru.basics.server.database.entity.Project;

public class ProjectDAO extends AbstractDAO<Project> {
    @Override
    public Class<Project> getEntityClass() {
        return Project.class;
    }
}
