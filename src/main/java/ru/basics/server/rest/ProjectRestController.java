package ru.basics.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.database.dao.ProjectDAO;
import ru.basics.server.database.entity.Project;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectRestController implements RestControllerInterface<Project> {
    ProjectDAO projectDAO;

    @Autowired
    public ProjectRestController(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    public ProjectRestController() {
    }

    public ResponseEntity<List<Project>> all() {
        return new ResponseEntity<>(projectDAO.findAllField(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Project> add(@RequestBody Project project) {

        if (project == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (!projectDAO.isExist(project.getNumber())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        projectDAO.create(project);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Project> getById(Long id) {
            Project project = projectDAO.findById(id);
            if(project == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Project> update(@RequestBody @Valid Project project) {
        if(project == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(!projectDAO.isExist(project.getNumber())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        projectDAO.update(project);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Project> delete(@RequestBody @Valid Project project) {
        if(project == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(!projectDAO.isExist(project.getNumber())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        projectDAO.delete(project);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Project> deleteById(Long id) {
        Project project = projectDAO.findById(id);
        if(project == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        projectDAO.delete(project);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
