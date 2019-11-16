package ru.basics.server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.repository.dao.AbstractDAO;
import ru.basics.server.repository.dao.CompanyDAO;
import ru.basics.server.entity.Company;
import ru.basics.server.service.AbstractService;
import ru.basics.server.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyRestController extends AbstractRestController<Company> {

    CompanyService companyService;

    @Autowired
    public CompanyRestController(CompanyService companyService) {
        this.companyService = companyService;
    }

    public CompanyRestController() {
    }


    @RequestMapping(value = "/search/address-legal/{address}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Company> findByAddressLegal(@PathVariable("address") String address) {

        if (address == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Company company = companyService.findByField("adresslegal", address);
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

        Company company = companyService.findByField("adressdelivery", address);
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

        Company company = companyService.findByField("adresssend", address);
        if (company == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(company, HttpStatus.NO_CONTENT);
    }

    @Override
    public AbstractService getService() {
        return companyService;
    }
}
