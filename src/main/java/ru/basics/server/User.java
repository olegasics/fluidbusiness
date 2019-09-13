package main.java.ru.basics.server;

import net.bytebuddy.build.ToStringPlugin;

public class User {
@ToStringPlugin.Exclude
    private String login;
    private String first_name;
    private String lats_name;
    private String phone_number;
    private String password;
    private String city;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLats_name() {
        return lats_name;
    }

    public void setLats_name(String lats_name) {
        this.lats_name = lats_name;
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
}
