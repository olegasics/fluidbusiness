package ru.basics.server.database.entity;

import javax.persistence.*;

@MappedSuperclass
public class AbstractPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String phoneNumber;

    @Column(unique = true)
    private String email;

    public AbstractPerson() {
    }

    public AbstractPerson(String name) {
        this.name = name;
    }

    public AbstractPerson(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public AbstractPerson(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
