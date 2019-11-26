package ru.basics.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Component
@Entity
@Table
public class Waybill implements Serializable {

    private static final long serialVersionUID = 3453193554620302391L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private Long number;

    @Column
    private Date dateSend;

    @Column
    private int numSeats;

    @Column
    private double weight;

    @Column
    private double volume;


    @OneToMany(mappedBy = "waybill")
    @LazyCollection(LazyCollectionOption.FALSE)
    @Fetch(FetchMode.SELECT)
    private List<WaybillDocument> waybillDocuments;

    @ManyToOne
    @JoinColumn(name = "forwarder_id")
    private Company forwarder;

    @ManyToOne
    @JoinColumn(name = "send_company_id")
    private Company sendCompany;

    @ManyToOne
    @JoinColumn(name = "delivery_company_id")
    private Company deliveryCompany;

    public void addItem(WaybillDocument waybillDocument) {
        waybillDocuments.add(waybillDocument);
    }

    public Waybill() {
    }

    public Waybill(Long id) {
        this.id = id;
    }

    public Waybill(Long number, int numSeats, double weight, double volume) {
        this.number = number;
        this.numSeats = numSeats;
        this.weight = weight;
        this.volume = volume;
    }

    public Waybill(Long number, Date dateSend, List<String> items, int numSeats,
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


    public List<WaybillDocument> getWaybillDocuments() {
        return waybillDocuments;
    }

    public void setWaybillDocuments(List<WaybillDocument> waybillDocuments) {
        this.waybillDocuments = waybillDocuments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
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
                '}';
    }
}
