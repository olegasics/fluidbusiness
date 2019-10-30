package ru.basics.server.database.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private String contactPersonName;

    @Column
    private String contactPersonPhone;

    @Column
    String contactPersonEmail;

    @Column
    private String adressLegal;

    @Column
    private String adressSend;

    @Column
    private String adressDelivery;

    @OneToMany(mappedBy = "company")
    private List<DriverData> driverData;

    @OneToMany(mappedBy = "company")
    private List<Document> documents;

    @OneToMany(mappedBy = "payer")
    private List<Document> documentsPayer;

    @OneToMany(mappedBy = "endCustomer")
    private List<Project> companies;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "project_company",
    joinColumns = @JoinColumn(name = "company_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id")
    )
    private List<Project> projects = new ArrayList<>();

    @OneToMany(mappedBy = "forwarder")
    private List<Waybill> forwarderWaybills;

    @OneToMany(mappedBy = "sendCompany")
    private List<Waybill> sendCompanyWaybills;

    @OneToMany(mappedBy = "deliveryCompany")
    private List<Waybill> deliveryCompanyWaybills;

    public Company() {
    }

    public Company(String name, String contactPersonName, String contactPersonPhone,
                   String contactPersonEmail, String adressLegal, String adressSend,
                   String adressDelivery) {
        this.name = name;
        this.contactPersonName = contactPersonName;
        this.contactPersonPhone = contactPersonPhone;
        this.contactPersonEmail = contactPersonEmail;
        this.adressLegal = adressLegal;
        this.adressSend = adressSend;
        this.adressDelivery = adressDelivery;
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public List<Waybill> getForwarderWaybills() {
        return forwarderWaybills;
    }

    public void setForwarderWaybills(List<Waybill> forwarderWaybills) {
        this.forwarderWaybills = forwarderWaybills;
    }

    public List<Waybill> getSendCompanyWaybills() {
        return sendCompanyWaybills;
    }

    public void setSendCompanyWaybills(List<Waybill> sendCompanyWaybills) {
        this.sendCompanyWaybills = sendCompanyWaybills;
    }

    public List<Waybill> getDeliveryCompanyWaybills() {
        return deliveryCompanyWaybills;
    }

    public void setDeliveryCompanyWaybills(List<Waybill> deliveryCompanyWaybills) {
        this.deliveryCompanyWaybills = deliveryCompanyWaybills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Project> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Project> companies) {
        this.companies = companies;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public List<Document> getDocumentsPayer() {
        return documentsPayer;
    }

    public void setDocumentsPayer(List<Document> documentsPayer) {
        this.documentsPayer = documentsPayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactPersonPhone() {
        return contactPersonPhone;
    }

    public void setContactPersonPhone(String contactPersonPhone) {
        this.contactPersonPhone = contactPersonPhone;
    }

    public String getContactPersonEmail() {
        return contactPersonEmail;
    }

    public void setContactPersonEmail(String contactPersonEmail) {
        this.contactPersonEmail = contactPersonEmail;
    }

    public String getAdressLegal() {
        return adressLegal;
    }

    public void setAdressLegal(String adressLegal) {
        this.adressLegal = adressLegal;
    }

    public String getAdressSend() {
        return adressSend;
    }

    public void setAdressSend(String adressSend) {
        this.adressSend = adressSend;
    }

    public String getAdressDelivery() {
        return adressDelivery;
    }

    public void setAdressDelivery(String adressDelivery) {
        this.adressDelivery = adressDelivery;
    }

    public List<DriverData> getDriverData() {
        return driverData;
    }

    public void setDriverData(List<DriverData> driverData) {
        this.driverData = driverData;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name;

    }
}
