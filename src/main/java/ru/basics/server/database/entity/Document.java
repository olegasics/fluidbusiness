package ru.basics.server.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column
    private Date date;

    @Column
    private boolean status;

    @Column
    private String file;

    @OneToMany(mappedBy = "document", fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<WaybillDocument> waybillDocuments;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "payer_company_id")
    private Company payer;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project numProject;

//    @ManyToMany(mappedBy = "invoices", fetch = FetchType.EAGER)
//    private Set<Waybill> waybills = new HashSet<>();

    public void addItem(WaybillDocument waybillDocument) {
        waybillDocuments.add(waybillDocument);
    }

    public Document() {
    }

    public Document(String name, Project numProject) {
        this.name = name;
        this.numProject = numProject;
    }

    public Document(String name, Company company, Date date) {
        this.name = name;
        this.company = company;
        this.date = date;
    }

//    public Set<Waybill> getWaybills() {
//        return waybills;
//    }

//    public void setWaybills(Set<Waybill> waybills) {
//        this.waybills = waybills;
//    }


    public List<WaybillDocument> getWaybillDocuments() {
        return waybillDocuments;
    }

    public void setWaybillDocuments(List<WaybillDocument> waybillDocuments) {
        this.waybillDocuments = waybillDocuments;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
