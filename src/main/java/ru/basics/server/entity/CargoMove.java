package ru.basics.server.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class CargoMove implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean status;

    @Column
    private String nameCargo;

    @Column
    private String trackNumber;

    @Column
    private boolean upd;

    @OneToOne
    private Waybill waybill;

    @OneToMany(mappedBy = "cargoMove")
    @LazyCollection(LazyCollectionOption.FALSE)
    @Fetch(FetchMode.SELECT)
    private List<WaybillDocument> waybillDocuments;

    public CargoMove(boolean status, String nameCargo, String trackNumber, boolean upd, Waybill waybill) {
        this.status = status;
        this.nameCargo = nameCargo;
        this.trackNumber = trackNumber;
        this.upd = upd;
        this.waybill = waybill;
    }

    public CargoMove() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNameCargo() {
        return nameCargo;
    }

    public void setNameCargo(String nameCargo) {
        this.nameCargo = nameCargo;
    }

    public String getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(String trackNumber) {
        this.trackNumber = trackNumber;
    }

    public boolean isUpd() {
        return upd;
    }

    public void setUpd(boolean upd) {
        this.upd = upd;
    }

    public Waybill getWaybill() {
        return waybill;
    }

    public void setWaybill(Waybill waybill) {
        this.waybill = waybill;
    }
}
