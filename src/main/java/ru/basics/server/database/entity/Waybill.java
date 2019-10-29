package ru.basics.server.database.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Waybill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private int number;

    @Column
    private Date dateSend;

    @Column
    private List<String> items;

    @Column
    private int numSeats;

    @Column
    private double weight;

    @Column
    private double volume;

    @ManyToOne
    @JoinColumn(name = "forwarder_id")
    private Company forwarder;

    @ManyToOne
    @JoinColumn(name = "send_company_id")
    private Company sendCompany;

    @ManyToOne
    @JoinColumn(name = "delivery_company_id")
    private Company deliveryCompany;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "waybill_document",
            joinColumns = {@JoinColumn(name = "waybill_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "document_id", referencedColumnName = "id")}
    )
    private Set<Document> invoices = new HashSet<>();

    public Waybill() {
    }

    public Waybill(int number, int numSeats, double weight, double volume) {
        this.number = number;
        this.numSeats = numSeats;
        this.weight = weight;
        this.volume = volume;
    }

    public Waybill(int number, Date dateSend, List<String> items, int numSeats,
                   double weight, double volume, Company forwarder, Company sendCompany, Company deliveryCompany) {
        this.number = number;
        this.dateSend = dateSend;
        //this.items = items;
        this.numSeats = numSeats;
        this.weight = weight;
        this.volume = volume;
        this.forwarder = forwarder;
        this.sendCompany = sendCompany;
        this.deliveryCompany = deliveryCompany;
    }

//    public void addItems(String items) {
//        this.items.add(items);
//    }

    public void addInvoice(Document document) {
        invoices.add(document);
    }

    public Set<Document> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Document> invoices) {
        this.invoices = invoices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDateSend() {
        return dateSend;
    }

    public void setDateSend(Date dateSend) {
        this.dateSend = dateSend;
    }

//    public List<String> getItems() {
//        return items;
//    }
//
//    public void setItems(List<String> items) {
//        this.items = items;
//    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public Company getForwarder() {
        return forwarder;
    }

    public void setForwarder(Company forwarder) {
        this.forwarder = forwarder;
    }

    public Company getSendCompany() {
        return sendCompany;
    }

    public void setSendCompany(Company sendCompany) {
        this.sendCompany = sendCompany;
    }

    public Company getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(Company deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    @Override
    public String toString() {
        return "Waybill{" +
                "id=" + id +
                ", number=" + number +
                ", dateSend=" + dateSend +
                ", numSeats=" + numSeats +
                ", weight=" + weight +
                ", volume=" + volume +
                ", forwarder=" + forwarder +
                ", sendCompany=" + sendCompany +
                ", deliveryCompany=" + deliveryCompany +
                ", invoices=" + invoices +
                '}';
    }
}
