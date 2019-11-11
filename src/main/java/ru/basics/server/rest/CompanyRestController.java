package ru.basics.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.database.dao.CompanyDAO;
import ru.basics.server.database.entity.Company;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyRestController extends RestControllerInterface<Company, CompanyDAO> {

    CompanyDAO companyDAO;

    @Autowired
    public CompanyRestController(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    public CompanyRestController() {
    }

    /*
    @Override
    public ResponseEntity<Company> add(Company company) {
        if(company == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        companyDAO.create(company);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<Company>> all() {
        List<Company> companies = companyDAO.findAllField();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Company> getById(Long id) {
        Company company = companyDAO.findById(id);
        if(company == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Company> update(Company company) {
        if(company == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        companyDAO.update(company);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Company> delete(Company company) {
        if(company == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(companyDAO.findById(company.getId()) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        companyDAO.delete(company);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Company> deleteById(Long id) {
        Company company = companyDAO.findById(id);
        if(company == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        companyDAO.delete(company);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

     */
}
