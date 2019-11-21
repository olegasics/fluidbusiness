package ru.basics.server.web;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import ru.basics.server.repository.exceptions.BadRequestException;
import ru.basics.server.repository.exceptions.EntityNotFoundException;
import ru.basics.server.repository.exceptions.HibernateDBException;
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

    @Override
    public Logger getLogger() {
        return LoggerFactory.getLogger(ProjectRestController.class);
    }

    @RequestMapping(value = "/search/{number}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Project> findByNumber(@PathVariable("number") String number) {
        if (number == null) {
            getLogger().warn("Неверный запрос: {}. Метод /findByNumber", number);
            throw new BadRequestException("Не верный запрос. Номер проекта не может быть " + number);
        }
        Project project;
        try {
            project = projectService.findByField("name", number);
        } catch (HibernateException e) {
            getLogger().error("Ошибка при поиске проекта по номеру. Неверный номер: {}. Метод /findByField", number);
            throw new HibernateDBException(e.getMessage());
        }
        if (project == null) {
            getLogger().warn("Не найден проект в базе данных: {}", number);
            throw new EntityNotFoundException("Проекта с номером: " + number + " не найдено в базе данных");
        }

        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @RequestMapping(value = "/search/end-customer/{idCustomer:\\d+}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Project>> findByCustomer(@PathVariable Long idCustomer) {
        if (idCustomer == null) {
            getLogger().warn("Неверный запрос: {}. Метод /findByCustomer", idCustomer);
            throw new BadRequestException("Неверный запрос. Заказчик с id=" + idCustomer + " не найден в базе данных");
        }
        try {
            Company customer = companyService.findById(idCustomer);
            List<Project> projectsForSerach = projectService.findAllField();
            for (Project project : projectsForSerach) {
                if (project.getEndCustomer().getId() == idCustomer) {
                    projects.add(project);
                }
            }
        } catch (HibernateException e) {
            getLogger().error("Ошибка при поиске проекта по id заказчика. Неверный id: {}. Метод /findByCustomer", idCustomer);
            throw new HibernateDBException(e.getMessage());
        }

        if (projects.isEmpty()) {
            getLogger().warn("Не найдено проектов с указаным id закачика: {}", idCustomer);
            throw new EntityNotFoundException("Проект с заказчиком: " + idCustomer + " не найден в базе данных");
        }

        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @Override
    public AbstractService getService() {
        return projectService;
    }
}
