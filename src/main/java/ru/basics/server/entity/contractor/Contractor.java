package ru.basics.server.entity.contractor;

import javax.persistence.Column;
import javax.persistence.Id;

public class Contractor {

    @Column
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String phone;

    @Column
    private  String city;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void Contractor(String name, String phone, String city) {
        this.name = name;

    }

    @Override
    public String toString() {
        return name;
    }
}
