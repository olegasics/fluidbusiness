package ru.basics.server.database.entity;

import javax.persistence.*;

@Entity
@Table
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private static PositionEnum name;
}
