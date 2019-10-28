package ru.basics.server.database.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    public Waybill() {
    }

    public Waybill(int number, List<String> items, int numSeats, double weight, double volume) {
        this.number = number;
        this.items = items;
        this.numSeats = numSeats;
        this.weight = weight;
        this.volume = volume;
    }

    public Waybill(int number, Date dateSend, List<String> items, int numSeats,
                   double weight, double volume, Company forwarder, Company sendCompany, Company deliveryCompany) {
        this.number = number;
        this.dateSend = dateSend;
        this.items = items;
        this.numSeats = numSeats;
        this.weight = weight;
        this.volume = volume;
        this.forwarder = forwarder;
        this.sendCompany = sendCompany;
        this.deliveryCompany = deliveryCompany;
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

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

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
}
