package ru.basics.server.entity.cargo.cargoMove;

import ru.basics.server.entity.cargo.forwarders.Forwarders;
import ru.basics.server.entity.contractor.Contractor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cargo_move")
public class CargoMove {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column()
    private String statusMove;

    @Column
    private String RP;

    @Column
    private String endCustomer;

    @Column
    private String nameCargo;

    @Column
    private String placeLoading;

    @Column
    private String placeUnloading;

    @Column
    private Date dateSend;

    @Column
    private Date dateDelivery;

    @Column
    @OneToOne
    private Forwarders forwarder;

    @Column
    @OneToOne
    private Contractor contractor;

    @Column
    private String invoce;

    @Column
    private String trackNumber;

    @Column
    private int TTNNumber;

    @Column
    private boolean upd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusMove() {
        return statusMove;
    }

    public void setStatusMove(String statusMove) {
        this.statusMove = statusMove;
    }

    public String getRP() {
        return RP;
    }

    public void setRP(String RP) {
        this.RP = RP;
    }

    public String getEndCustomer() {
        return endCustomer;
    }

    public void setEndCustomer(String endCustomer) {
        this.endCustomer = endCustomer;
    }

    public String getNameCargo() {
        return nameCargo;
    }

    public void setNameCargo(String nameCargo) {
        this.nameCargo = nameCargo;
    }

    public String getPlaceLoading() {
        return placeLoading;
    }

    public void setPlaceLoading(String placeLoading) {
        this.placeLoading = placeLoading;
    }

    public String getPlaceUnloading() {
        return placeUnloading;
    }

    public void setPlaceUnloading(String placeUnloading) {
        this.placeUnloading = placeUnloading;
    }

    public Date getDateSend() {
        return dateSend;
    }

    public void setDateSend(Date dateSend) {
        this.dateSend = dateSend;
    }

    public Date getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(Date dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public Forwarders getForwarder() {
        return forwarder;
    }

    public void setForwarder(Forwarders forwarder) {
        this.forwarder = forwarder;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public String getInvoce() {
        return invoce;
    }

    public void setInvoce(String invoce) {
        this.invoce = invoce;
    }

    public String getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(String trackNumber) {
        this.trackNumber = trackNumber;
    }

    public int getTTNNumber() {
        return TTNNumber;
    }

    public void setTTNNumber(int TTNNumber) {
        this.TTNNumber = TTNNumber;
    }

    public boolean isUpd() {
        return upd;
    }

    public void setUpd(boolean upd) {
        this.upd = upd;
    }
}
