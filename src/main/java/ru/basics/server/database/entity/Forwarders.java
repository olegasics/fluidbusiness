package ru.basics.server.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "forwarders")

public class Forwarders extends Contractors {

    @Id
    @Column
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    @Column
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

    public Forwarders() {

    }

    public Forwarders(String name, String phone, String city, String email) {
        this.name = name;
        this.phone = phone;
        this.city = city;
        this.email = email;
    }

    @Override
    public void addNewContactor(Contractors contractors) {
//        super.addNewContactor(contractors);
    }

    @Override
    public String toString() {
        return "forwarder_name: " + name;
    }
}
