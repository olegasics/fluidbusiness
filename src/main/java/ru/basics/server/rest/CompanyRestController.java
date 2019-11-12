package ru.basics.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.database.dao.AbstractDAO;
import ru.basics.server.database.dao.CompanyDAO;
import ru.basics.server.database.entity.Company;
import ru.basics.server.utils.restUtils.RestUtils;

@RestController
@RequestMapping("/companies")
public class CompanyRestController extends AbstractRestController<Company> {

    CompanyDAO companyDAO;

    @Autowired
    public CompanyRestController(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    public CompanyRestController() {
    }

    @Override
    public AbstractDAO getDao() {
        return companyDAO;
    }

    @RequestMapping(value = "/search/address-legal/{address}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Company> findByAddressLegal(@PathVariable("address") String address) {

        if (address == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Company company = companyDAO.findByField("adresslegal", address);
        if (company == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(company, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/search/address-delivery/{address}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Company> findByAddressDelivery(@PathVariable("address") String address) {
        if (address == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Company company = companyDAO.findByField("adressdelivery", address);
        if (company == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(company, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/search/address-send/{address}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Company> findByAddressSend(@PathVariable("address") String address) {
        if (address == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Company company = companyDAO.findByField("adresssend", address);
        if (company == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(company, HttpStatus.NO_CONTENT);
    }

}
