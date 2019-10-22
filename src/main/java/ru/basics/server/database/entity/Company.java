package ru.basics.server.database.entity;

import javax.persistence.*;
import java.util.List;

@MappedSuperclass
@Entity
@Table
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    protected Long id;

    private TypeCompanyEnum typeCompanyEnum;

    @Column(nullable = false)
    protected String name;

    private Contract contract;

    private String contactPerson;

    private String contactPersonPhone;

    private String contactPersonEmail;

    private String adress_legal;
    private String adresses_send;
    private String adresses_delivery;

    private Driver driver;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sendContractor")
    private List<Waybill> sendWaybills;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryContactor")
    private List<Waybill> deliveryContractor;

    public Company() {
    }

    public TypeCompanyEnum getTypeCompanyEnum() {
        return typeCompanyEnum;
    }

    public void setTypeCompanyEnum(TypeCompanyEnum typeCompanyEnum) {
        this.typeCompanyEnum = typeCompanyEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactPersonPhone() {
        return contactPersonPhone;
    }

    public void setContactPersonPhone(String contactPersonPhone) {
        this.contactPersonPhone = contactPersonPhone;
    }

    public String getContactPersonEmail() {
        return contactPersonEmail;
    }

    public void setContactPersonEmail(String contactPersonEmail) {
        this.contactPersonEmail = contactPersonEmail;
    }

    public String getAdress_legal() {
        return adress_legal;
    }

    public void setAdress_legal(String adress_legal) {
        this.adress_legal = adress_legal;
    }

    public String getAdresses_send() {
        return adresses_send;
    }

    public void setAdresses_send(String adresses_send) {
        this.adresses_send = adresses_send;
    }

    public String getAdresses_delivery() {
        return adresses_delivery;
    }

    public void setAdresses_delivery(String adresses_delivery) {
        this.adresses_delivery = adresses_delivery;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Company(String name) {
        this.name = name;
    }

    public Company(String name, String email) {
        this.name = name;

    }

    public Company(String name, String phoneNumber, String email) {
        this.name = name;

    }


}
