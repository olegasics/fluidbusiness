package ru.basics.server.database.entity;

import javax.persistence.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String city;

    @Column(unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private Position position;

    @ManyToMany
    private Project project;

    public User() {
    }

    public User(String name, String login, String password,
                String email, Position position, Project project) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.position = position;
        this.project = project;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String name, String login, String password,
                String email, String city, String phoneNumber,
                Position position, Project project) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
