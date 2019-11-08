package ru.basics.server.database.entity;

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

    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String number;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "endCustomer")
    private  Company endCustomer;

    @OneToMany(mappedBy = "numProject", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @LazyCollection(LazyCollectionOption.FALSE)
    @Fetch(FetchMode.SELECT)
    private transient List<Document> document = new ArrayList<>();

    @ManyToMany(mappedBy = "projects")
    @LazyCollection(LazyCollectionOption.FALSE)
    @Fetch(FetchMode.SELECT)
    private List<Company> providers = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_project",
            joinColumns = {@JoinColumn(name = "project_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    @Fetch(FetchMode.SELECT)
    private Set<User> team = new HashSet<User>();

    @OneToMany(mappedBy = "project")
    @LazyCollection(LazyCollectionOption.FALSE)
    @Fetch(FetchMode.SELECT)
    private List<Task> task = new ArrayList<>();

    public void addUser(User user) {
        team.add(user);
    }

    public Project() {
    }

    public Project(String number, Company endCustomer) {
        this.number = number;
        this.endCustomer = endCustomer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<User> getTeam() {
        return team;
    }



    public void setTeam(Set<User> team) {
        this.team = team;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Company getEndCustomer() {
        return endCustomer;
    }

    public void setEndCustomer(Company endCustomer) {
        this.endCustomer = endCustomer;
    }

    public List<Document> getDocument() {
        return document;
    }

    public void setDocument(List<Document> document) {
        this.document = document;
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
                "number='" + number + '\'' +
                '}';
    }
}
