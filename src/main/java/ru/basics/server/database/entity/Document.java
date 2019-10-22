package ru.basics.server.database.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String number;
    private Project project;
    private Boolean status; // оплачен или нет
    private Date date;

    private Company contractor; // от кого выставлен
    private Company payer; // плательщик
}
