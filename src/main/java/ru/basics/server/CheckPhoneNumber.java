package ru.basics.server;

public class CheckPhoneNumber {

    public void check (String phoneNumber) {
        phoneNumber.matches("^\\(\\+\\d\\)-\\d-\\d");

    }

}
