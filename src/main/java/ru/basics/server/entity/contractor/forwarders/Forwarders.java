package ru.basics.server.entity.contractor.forwarders;

import javax.persistence.Column;
import javax.persistence.Id;

public class Forwarders {

    @Id
    @Column
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    @Column
    private String city;
}
