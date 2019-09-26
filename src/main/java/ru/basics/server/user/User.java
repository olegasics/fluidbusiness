package ru.basics.server.user;

import com.sun.istack.NotNull;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
@Table(name ="users")
public class User {

    @NotNull
    @GeneratedValue
    @Column(name = "id_user")
    private int id;
    @Id
    @Column(name = "user_login")
    private String login;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_phone")
    private String phone_number;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_city")
    private String city;

    public User() {

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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
            return "id_user: " + getId() + "login_user: " + getLogin();
    }
}
