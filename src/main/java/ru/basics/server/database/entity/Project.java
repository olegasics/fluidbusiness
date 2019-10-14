package ru.basics.server.database.entity;

import javax.persistence.*;

@Entity
@Table
public class Project {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String numProject;

    @Column
    private String manager;

    @Column
    private Customer endCustomer;

    public Project(String numProject, String manager, Customer endCustomer) {
        this.numProject = numProject;
        this.manager = manager;
        this.endCustomer = endCustomer;
    }

    public String getNumProject() {
        return numProject;
    }

    public void setNumProject(String numProject) {
        this.numProject = numProject;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Customer getEndCustomer() {
        return endCustomer;
    }

    public void setEndCustomer(Customer endCustomer) {
        this.endCustomer = endCustomer;
    }
}
