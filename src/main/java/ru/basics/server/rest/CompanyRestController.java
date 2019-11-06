package ru.basics.server.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.basics.server.database.dao.CompanyDAO;
import ru.basics.server.database.entity.Company;
import ru.basics.server.database.entity.Document;

import java.util.List;

public class CompanyRestController implements RestController<Company> {

    CompanyDAO companyDAO;

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
}
