package ru.basics.server.database.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private String contactPersonName;

    @Column
    private String contactPersonPhone;

    @Column
    String contactPersonEmail;

    @Column
    private String adressLegal;

    @Column
    private String adressSend;

    @Column
    private String adressDelivery;

    @OneToMany(mappedBy = "company")
    private List<DriverData> driverData;

    public Company(String name, String contactPersonName, String contactPersonPhone,
                   String contactPersonEmail, String adressLegal, String adressSend,
                   String adressDelivery) {
        this.name = name;
        this.contactPersonName = contactPersonName;
        this.contactPersonPhone = contactPersonPhone;
        this.contactPersonEmail = contactPersonEmail;
        this.adressLegal = adressLegal;
        this.adressSend = adressSend;
        this.adressDelivery = adressDelivery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
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

    public String getAdressLegal() {
        return adressLegal;
    }

    public void setAdressLegal(String adressLegal) {
        this.adressLegal = adressLegal;
    }

    public String getAdressSend() {
        return adressSend;
    }

    public void setAdressSend(String adressSend) {
        this.adressSend = adressSend;
    }

    public String getAdressDelivery() {
        return adressDelivery;
    }

    public void setAdressDelivery(String adressDelivery) {
        this.adressDelivery = adressDelivery;
    }

    public List<DriverData> getDriverData() {
        return driverData;
    }

    public void setDriverData(List<DriverData> driverData) {
        this.driverData = driverData;
    }
}
