package ru.basics.server.database.entity;

import javax.persistence.*;

@Entity
@Table
public class CargoMove {
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

}
