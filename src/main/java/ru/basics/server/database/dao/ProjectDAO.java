package ru.basics.server.database.dao;

import org.springframework.stereotype.Service;
import ru.basics.server.database.entity.Project;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProjectDAO extends AbstractDAO<Project> {
    @Override
    public Class<Project> getEntityClass() {
        return Project.class;
    }
}
