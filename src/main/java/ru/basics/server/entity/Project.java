package ru.basics.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Project implements Serializable {

    private static final long serialVersionUID = -7701301328257898189L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(unique = true, nullable = false)
    protected String name;

    @ManyToOne
    @JoinColumn(name = "endCustomer")
    protected Company endCustomer;

    @JsonIgnore
    @OneToMany(mappedBy = "numProject", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @LazyCollection(LazyCollectionOption.FALSE)
    @Fetch(FetchMode.SELECT)
    private List<Document> documents = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "projects")
    @LazyCollection(LazyCollectionOption.FALSE)
    @Fetch(FetchMode.SELECT)
    private List<Company> providers = new ArrayList<>();


    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "user_project",
            joinColumns = {@JoinColumn(name = "project_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    @Fetch(FetchMode.SELECT)
    private List<User> team = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "project")
    @LazyCollection(LazyCollectionOption.FALSE)
    @Fetch(FetchMode.SELECT)
    private List<Task> task = new ArrayList<>();

    public void addUser(User user) {
        team.add(user);
    }

    public Project() {
    }

    public Project(List<User> team) {
        this.team = team;
    }

    public Project(Long id) {
        this.id = id;
    }

    public Project(String name, Company endCustomer) {
        this.name = name;
        this.endCustomer = endCustomer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getTeam() {
        return team;
    }


    public void setTeam(List<User> team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTask() {
        return task;
    }

    public void setTask(List<Task> task) {
        this.task = task;
    }

    public Company getEndCustomer() {
        return endCustomer;
    }

    public void setEndCustomer(Company endCustomer) {
        this.endCustomer = endCustomer;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public List<Company> getProviders() {
        return providers;
    }

    public void setProviders(List<Company> providers) {
        this.providers = providers;
    }

    @Override
    public String toString() {
        return "Project{" +
                "Number" + name +
                '}';
    }
}
