package ru.basics.server.database.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cargo_move")
public class CargoMove {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String status;

    @Column(nullable = false)
    private String nameCargo;

    @Column
    private String trackNumber;

    @Column
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "waybill_id")
    private Waybill TTNNumber;

    @Column
    private boolean upd;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public Waybill getTTNNumber() {
        return TTNNumber;
    }

    public void setTTNNumber(Waybill TTNNumber) {
        this.TTNNumber = TTNNumber;
    }

    public boolean isUpd() {
        return upd;
    }

    public void setUpd(boolean upd) {
        this.upd = upd;
    }


    public CargoMove(String nameCargo, String trackNumber, Waybill TTNNumber, boolean upd) {

        this.nameCargo = nameCargo;
        ;
        // this.forwarders = forwarder;
        // TODO как идея сделать this.invoces  = Arrays.asList(и тут счета через запятую), при создании объекта нужно будет передавать список счетов тогда
        this.trackNumber = trackNumber;
        this.TTNNumber = TTNNumber;
        this.upd = upd;
    }

    public CargoMove() {

    }

}
