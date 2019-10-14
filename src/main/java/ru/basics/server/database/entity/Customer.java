package ru.basics.server.database.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Customer extends AbstractPerson {

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    @Column
    public String contract;

    public Customer(String contract) {
        this.contract = contract;
    }

    public Customer(String name, String phone, String contract, String email) {
        super(name,phone,email);
        this.contract = contract;
    }

    public Customer(String name, String phone, String email) {
        super(name,phone,email);
    }

    public Customer(String name, String email) {
        super(name, email);
    }

    @Override
    public String toString() {
        return "customer name: " + name;
    }


}
