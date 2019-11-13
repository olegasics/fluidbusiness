package ru.basics.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.basics.server.database.dao.AbstractDAO;
import ru.basics.server.database.dao.CompanyDAO;
import ru.basics.server.database.dao.ProjectDAO;
import ru.basics.server.database.entity.Company;
import ru.basics.server.database.entity.Project;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectRestController extends AbstractRestController<Project> {
    ProjectDAO projectDAO;
    CompanyDAO companyDAO;
    CargoMoveRestController cargoMoveRestController;
    AbstractRestController abstractRestController;
    List<Project> projects;

    @Autowired
    public ProjectRestController(ProjectDAO projectDAO, CompanyDAO companyDAO) {
        this.projectDAO = projectDAO;
        this.companyDAO = companyDAO;
    }

    public ProjectRestController() {
    }

    @RequestMapping(value = "/search/{number}", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Project> findByNumber(@PathVariable("number") String number) {
        if(number == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Project project = projectDAO.findByField("name", number);
        if(project == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @RequestMapping(value = "/search/end-customer/{idCustomer:\\d+}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Project> findByCustomer(@PathVariable("idCustomer") Long idCustomer) {
        if (idCustomer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Company customer = companyDAO.findById(idCustomer);
        Project project = projectDAO.findByField("endCustomer", customer);
        if (project == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        do {
            projects.add(project);
            project = projectDAO.findByField("endCustomer", customer);

        } while (project != null);

        return new ResponseEntity<>(project, HttpStatus.OK);
    }



    @Override
    public AbstractDAO getDao() {
        return projectDAO;
    }
}
