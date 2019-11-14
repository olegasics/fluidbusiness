package ru.basics.server.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basics.server.database.dao.AbstractDAO;
import ru.basics.server.database.dao.ProjectDAO;
import ru.basics.server.database.entity.Project;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProjectService extends AbstractService<Project> {
    @Autowired
    ProjectDAO projectDAO;

    @Override
    public AbstractDAO getDao() {
        return projectDAO;
    }


}
