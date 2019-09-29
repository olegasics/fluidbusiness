package ru.basics.server.entity.contractor;

import javax.persistence.Column;
import javax.persistence.Id;

public class Contractor {

    @Column
    @Id
    private Long id;

    @Column
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
