package ru.basics.server.entity.user;

import com.sun.istack.NotNull;
import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
@Table(name ="users")
public class User {



    @Column()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Id
    @Column()
    @NotNull
    private String login;
    @Column()
    private String name;
    @Column(unique = true)
    private String phone_number;
    @Column()
    @NotNull
    private String password;
    @Column()
    private String city;

    public User() {

    }

    public long getId() {
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
