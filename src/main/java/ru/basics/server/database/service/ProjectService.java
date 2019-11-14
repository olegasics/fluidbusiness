package ru.basics.server.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.basics.server.database.dao.AbstractDAO;
import ru.basics.server.database.dao.ProjectDAO;
import ru.basics.server.database.entity.Project;

public class ProjectService extends AbstractService<Project> {
    @Autowired
    ProjectDAO projectDAO;

    @Override
    public AbstractDAO getDao() {
        return projectDAO;
    }


}
