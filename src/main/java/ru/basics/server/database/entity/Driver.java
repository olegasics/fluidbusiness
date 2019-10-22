package ru.basics.server.database.entity;

import javax.persistence.*;

@Entity
@Table
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String carNum;
    private String carModel;
    private String phone;


}
