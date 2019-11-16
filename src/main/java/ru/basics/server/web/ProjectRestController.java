package ru.basics.server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.basics.server.repository.dao.AbstractDAO;
import ru.basics.server.repository.dao.CompanyDAO;
import ru.basics.server.repository.dao.ProjectDAO;
import ru.basics.server.entity.Company;
import ru.basics.server.entity.Project;
import ru.basics.server.service.AbstractService;
import ru.basics.server.service.CompanyService;
import ru.basics.server.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectRestController extends AbstractRestController<Project> {
    ProjectService projectService;
    CompanyService companyService;
    CargoMoveRestController cargoMoveRestController;
    AbstractRestController abstractRestController;
    List<Project> projects;

    @Autowired
    public ProjectRestController(ProjectService projectService, CompanyService companyService) {
        this.projectService = projectService;
        this.companyService = companyService;
    }

    public ProjectRestController() {
    }

    @RequestMapping(value = "/search/{number}", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Project> findByNumber(@PathVariable("number") String number) {
        if(number == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Project project = projectService.findByField("name", number);
        if(project == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @RequestMapping(value = "/search/end-customer/{idCustomer:\\d+}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Project>> findByCustomer(@PathVariable("idCustomer") Long idCustomer) {
        if (idCustomer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Company customer = companyService.findById(idCustomer);
        List<Project> projectsForSerach = projectService.findAllField();
        for(Project project : projectsForSerach) {
            if(project.getEndCustomer().getId() == idCustomer ) {
                projects.add(project);
            }
        }
        if(projects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @Override
    public AbstractService getService() {
        return projectService;
    }
}
