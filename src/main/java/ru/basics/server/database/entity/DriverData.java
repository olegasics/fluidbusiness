package ru.basics.server.database.entity;

import javax.persistence.*;

@Entity
@Table
public class DriverData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true)
    private String numberCar;

    @Column
    private String modelCar;

    @Column
    private String numberPhone;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public DriverData() {
    }

    public DriverData(String name, String numberCar, String modelCar, String numberPhone, Company company) {
        this.name = name;
        this.numberCar = numberCar;
        this.modelCar = modelCar;
        this.numberPhone = numberPhone;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberCar() {
        return numberCar;
    }

    public void setNumberCar(String numberCar) {
        this.numberCar = numberCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
