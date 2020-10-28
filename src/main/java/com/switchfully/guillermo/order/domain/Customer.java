package com.switchfully.guillermo.order.domain;

import java.util.UUID;

public class Customer extends User {
    private String address;
    private String phoneNumber;

    public Customer(String lastName, String firstName, String email, String address, String phoneNumber) {
        super(lastName, firstName, email);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Customer(UUID id, String lastName, String firstName, String email, String address, String phoneNumber) {
        super(id, lastName, firstName, email);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

}
