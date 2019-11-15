package ru.basics.server.repository.dao;

import org.springframework.stereotype.Service;
import ru.basics.server.entity.Project;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProjectDAO extends AbstractDAO<Project> {
    @Override
    public Class<Project> getEntityClass() {
        return Project.class;
    }

    public boolean isExist(String number) {
        return this.findByField("number", number) != null;
    }
}
