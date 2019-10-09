package ru.basics.server.database.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends AbstractPerson {
    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column
    private String city;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, String phoneNumber) {
        super(phoneNumber);

        this.login = login;
        this.password = password;
    }

    public User(String login, String password, String name, String phoneNumber, String city) {
        super(name, phoneNumber);

        this.login = login;
        this.password = password;
        this.city = city;
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
