package ru.basics.server.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.basics.server.entity.Company;
import ru.basics.server.repository.exceptions.BadRequestException;
import ru.basics.server.repository.exceptions.EntityNotFoundException;
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

    @Override
    public Logger getLogger() {
        return LoggerFactory.getLogger(CompanyRestController.class);
    }

    @Override
    public Class<Company> getEntityClass() {
        return Company.class;
    }

    @RequestMapping(value = "/search/address-legal/{address}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Company> findByAddressLegal(@PathVariable String address) {
        if (address == null) {
            getLogger().warn("Bad request in method /findByAddressLegal");
            throw new BadRequestException("Неверный запрос. Адрес не может быть " + address);
        }

        Company company = companyService.findByField("adressLegal", address);
        if (company == null) {
            getLogger().warn("Company with address legal - {} not found, in method /findByAddressLegal", address);
            throw new EntityNotFoundException("Компания с юридическим адресом: " + address + " не найдена в базе данных");
        }
        return new ResponseEntity<>(company, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/search/address-delivery/{address}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Company> findByAddressDelivery(@PathVariable("address") String address) {
        if (address == null) {
            getLogger().warn("Bad request in method /findByAddressDelivery");
            throw new BadRequestException("Неверный запрос. Адрес не может быть " + address);
        }

        Company company = companyService.findByField("adressDelivery", address);
        if (company == null) {
            getLogger().warn("Company with address delivery - {} not found, in method /findByAddressDelivery", address);
            throw new EntityNotFoundException(address);
        }

        return new ResponseEntity<>(company, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/search/address-send/{address}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Company> findByAddressSend(@PathVariable("address") String address) {
        if (address == null) {
            getLogger().warn("Bad request in method /findByAddressSend");
            throw new BadRequestException("Неверный запрос. Адрес не может быть " + address);
        }

        Company company = companyService.findByField("adressSend", address);
        if (company == null) {
            getLogger().warn("Company with address send - {} not found, in method /findByAddressSend", address);
            throw new EntityNotFoundException("Компания с адресом доставки: " + address + " не найдена в базе данных");
        }

        return new ResponseEntity<>(company, HttpStatus.NO_CONTENT);
    }

    @Override
    public AbstractService getService() {
        return companyService;
    }
}
