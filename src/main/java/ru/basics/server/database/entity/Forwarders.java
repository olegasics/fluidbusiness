package ru.basics.server.database.entity;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "forwarders")
public class Forwarders extends AbstractPerson {

    @Column
    String city;

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public Forwarders() {
    }
    public Forwarders(String name, String phone, String city, String email) {
        super(name,phone,email);
        this.city = city;
    }
    @Override
    public String toString() {
        return "forwarder_name: " + name;
    }
}
