package ru.basics.server.entity.contractor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


public abstract class Contractors {

    private Long id;


    private String name;

    private String email;


    private String phone;

    private String city;

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    public String getPhone() {
        return phone;
    }


    public String getCity() {
        return city;
    }

    public Contractors() {

    }

    public Contractors(String name, String phone, String city, String email) {
        this.name = name;
        this.phone = phone;
        this.city = city;
        this.email = email;
    }

    public void addNewContactor(Contractors contractors) {

    }


    @Override
    public String toString() {
        return "forwarder_name: " + name;
    }

}
