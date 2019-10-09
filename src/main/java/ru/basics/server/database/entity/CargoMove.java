package ru.basics.server.database.entity;

import javax.persistence.*;

@Entity
@Table(name = "cargo_move")
public class CargoMove {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String statusMove;

    @Column
    private String numberProject;

    @Column
    private String manager;

    @Column
    private String endCustomer;

    @Column
    private String nameCargo;

    @Column
    private String placeLoading;

    @Column
    private String placeUnloading;

    @Column
    private String dateSend;

    @Column
    private String dateDelivery;

    @Column
    private String forwarder;

    @Column
    private String contractor;

    @Column
    private String invoce;

    @Column
    private String trackNumber;

    @Column
    private int TTNNumber;

    @Column
    private boolean upd;

    public CargoMove(String statusMove, String numberProject, String manager, String endCustomer, String nameCargo, String placeLoading, String placeUnloading, String dateSend, String dateDelivery, String forwarder, String contractor, String invoce, String trackNumber, int TTNNumber, boolean upd) {
        this.statusMove = statusMove;
        this.numberProject = numberProject;
        this.manager = manager;
        this.endCustomer = endCustomer;
        this.nameCargo = nameCargo;
        this.placeLoading = placeLoading;
        this.placeUnloading = placeUnloading;
        this.dateSend = dateSend;
        this.dateDelivery = dateDelivery;
        this.forwarder = forwarder;
        this.contractor = contractor;
        this.invoce = invoce;
        this.trackNumber = trackNumber;
        this.TTNNumber = TTNNumber;
        this.upd = upd;
    }

    public CargoMove() {

    }

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

    public String getNumberProject() {
        return numberProject;
    }

    public void setNumberProject(String numberProject) {
        this.numberProject = numberProject;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
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

    public String getDateSend() {
        return dateSend;
    }

    public void setDateSend(String dateSend) {
        this.dateSend = dateSend;
    }

    public String getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(String dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public String getForwarder() {
        return forwarder;
    }

    public void setForwarder(String forwarder) {
        this.forwarder = forwarder;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
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

    @Override
    public String toString() {
        return "Number project: " + numberProject
                + "Место погрузки: " + placeLoading
                + "Место разгрузки: " + placeUnloading;
    }
}