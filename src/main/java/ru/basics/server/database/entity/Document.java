package ru.basics.server.database.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.zip.DataFormatException;

@Entity
@Table
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column
    private Date date;

    @Column
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "payer_company_id")
    private Company payer;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project numProject;

    public Document() {
    }

    public Document(String name, Company company, Date date) {
        this.name = name;
        this.company = company;
        this.date = date;
    }

    public Project getNumProject() {
        return numProject;
    }

    public void setNumProject(Project numProject) {
        this.numProject = numProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Company getPayer() {
        return payer;
    }

    public void setPayer(Company payer) {
        this.payer = payer;
    }
}
