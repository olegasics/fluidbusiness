package ru.basics.server.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.io.Serializable;

@Component
@Entity
@Table
public class WaybillDocument implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "waybill_id")
    private Waybill waybill;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "documents_id")
    private Document document;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cargo_move_id")
    private CargoMove cargoMove;

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
