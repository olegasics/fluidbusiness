package ru.basics.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.database.dao.ProjectDAO;
import ru.basics.server.database.entity.Project;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectRestController {
    ProjectDAO projectDAO;

    @Autowired
    public ProjectRestController(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @RequestMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    private ResponseEntity<List<Project>> all() {
        return new ResponseEntity<>(projectDAO.findAllField(), HttpStatus.OK);
    }
}
