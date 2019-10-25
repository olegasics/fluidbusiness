package ru.basics.server.database.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String number;

    @ManyToOne
    @JoinColumn(name = "endCustomer")
    private Company endCustomer;

    @OneToMany(mappedBy = "")
    private List<Document> document;

    private List<Company> providers;

    public Project() {
    }

    public Project(String number, Company endCustomer) {
        this.number = number;
        this.endCustomer = endCustomer;
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
}
