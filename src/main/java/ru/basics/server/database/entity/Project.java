package ru.basics.server.database.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Project {
    /**
     * Пользователь заходит во вкладку "Проекты"
     * Во вкладке отображаются вкладки с поставщиками, по переходу в которую можно посмотреть все отгрузки по данному проекту с этим поставщиком
     * Отгрузок от данного поставщика по одному проекту может быть несколько
     * Во вкладке с проектом есть вкладка "Отгрузка конечному заказчику + дата отгрузки"
     * По переходу в папку "Отгрузка конечному заказчику" отображаются все документы, связанные с этой отгрузкой, ее статус и т.д
     */
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String number;

    @Column
    private Company endCustomer;

    private List<Company> providers;
    private List<Contract> contracts;
    private List<User> team;


    public Project(String number, User manager, Company endCustomer) {
        this.number = number;
        this.endCustomer = endCustomer;
    }


}
