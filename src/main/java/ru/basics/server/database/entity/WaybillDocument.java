package ru.basics.server.database.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class WaybillDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "waybill_id")
    private Waybill waybill;

    @ManyToOne
    @JoinColumn(name = "documents_id")
    private Document document;

    private String item;

    @Column
    private int volume;

    @Column
    private int weight;

    public void addItem(String item, Integer volume, Integer weight) {
        this.item = item;
        this.volume = volume;
        this.weight = weight;
    }

    public WaybillDocument() {
    }

    public WaybillDocument(String item, int volume, int weight) {
        this.item = item;
        this.volume = volume;
        this.weight = weight;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Waybill getWaybill() {
        return waybill;
    }

    public void setWaybill(Waybill waybill) {
        this.waybill = waybill;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "WaybillDocument{" +
                "waybill=" + waybill +
                ", document=" + document +
                ", item='" + item + '\'' +
                ", volume=" + volume +
                ", weight=" + weight +
                '}';
    }
}
