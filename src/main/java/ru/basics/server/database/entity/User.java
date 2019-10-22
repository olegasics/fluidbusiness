package ru.basics.server.database.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String phone;

    private String email;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column
    private String city;

    @Column
    private Position position;


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public User() {
    }
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public User(String login, String password, String phoneNumber) {
        this.phone = phoneNumber;
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, String email, String name, String phoneNumber, String city, Position position) {
        this.name = name;
        this.phone = phoneNumber;
        this.email = email;
        this.login = login;
        this.password = password;
        this.city = city;
        this.position = position;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "login_user: " + getLogin();
    }
}
