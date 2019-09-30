package ru.basics.server.entity.contractor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contractor")
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

     public Contractor(String name, String phone, String city) {
        this.name = name;
        this.phone = phone;
        this.city = city;
    }

    public Contractor() {

    }

    public String getPhone() {
        return phone;
    }


    public String getCity() {
        return city;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
