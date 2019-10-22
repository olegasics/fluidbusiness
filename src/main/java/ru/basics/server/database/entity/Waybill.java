package ru.basics.server.database.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Waybill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @OneToOne(optional = true, mappedBy = "TTNNumber")
    private Long id;

    private CargoMove cargoMove;

    private Project numProject; // номер проекта
    private Date dateSend; // дата отправки
    private List<Document> documents;
    @ManyToOne
    @JoinColumn(name = "send_company_id", referencedColumnName = "id")
    private Company sendContractor; // грузотправитель
    @ManyToOne
    @JoinColumn(name = "delivery_company_id", referencedColumnName = "id")
    private Company deliveryContactor; // грузополучатель
    private List<String> items; // наименования груза
    private Double weight; // вес
    private Double volume; // объем
    private List<Document> documentSopr; // сопроводительые документы, следующие с грузом
    private String condCar; // условия перевозки
    private Company forwarder; // перевозчик


    public Waybill(Date dateSend, List<Document> documents, Company sendContractor, Company deliveryContactor,
                   List<String> items, Double weight, Double volume, List<Document> documentSopr, String condCar, Company forwarder) {
        this.dateSend = dateSend;
        this.documents = documents;
        this.sendContractor = sendContractor;
        this.deliveryContactor = deliveryContactor;
        this.items = items;
        this.weight = weight;
        this.volume = volume;
        this.documentSopr = documentSopr;
        this.condCar = condCar;
        this.forwarder = forwarder;
    }

    @Override
    public String toString() {
        return "\nWaybill{" +
                "id=" + id +
                ", numProject=" + numProject +
                ", dateSend=" + dateSend +
                ", sendContractor=" + sendContractor +
                ", endContactor=" + deliveryContactor +
                '}';
    }
}
