package ru.basics.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.jboss.logging.Field;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "person")
public class User implements Serializable {

    private static final long serialVersionUID = -7227124202865754589L;

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

    @Column
    private Position position;

    @JsonIgnore
    @ManyToMany(mappedBy = "team", fetch = FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.FALSE)
    @Fetch(FetchMode.SELECT)
    private List<Project> projects;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.FALSE)
    @Fetch(FetchMode.SELECT)
    private List<Task> tasks;

    @Column
    private Boolean deleted;

    public void addProject(Project project) {
        projects.add(project);
    }

    public User() {
    }

    public User(String name, String login, String password,
                String email, Position position, List<Project> project) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.position = position;
        this.projects = project;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String login, String password,
                String email, String city, String phoneNumber) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public User(String name, String login, String password,
                String email, String city, String phoneNumber,
                Position position) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.position = position;
    }

    public User(Long id) {
        this.id = id;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
//
//    public List<Project> getProjects() {
//        return projects;
//    }
//
//    public void setProjects(List<Project> projects) {
//        this.projects = projects;
//    }

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

    public Position getPosotionUser() {
        return position;
    }

    public void setPosotionUser(Position posotion) {
        this.position = posotion;
    }

    public List<Project> getProject() {
        return projects;
    }

    public void setProject(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", status='" + deleted + '\'' +
                '}';
    }
}
