package ru.basics.server.database.entity;

import javax.persistence.*;
import java.io.Serializable;

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

}
