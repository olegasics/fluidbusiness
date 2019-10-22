package ru.basics.server.database.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Date date;
    private Project project;
    private String file; // ссылка на файл
    public Company contractor;
}
