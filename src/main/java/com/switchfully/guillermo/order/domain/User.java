package com.switchfully.guillermo.order.domain;

import java.util.UUID;

public abstract class User {
    private UUID id;
    private String lastName;
    private String firstName;
    private String email;

    public User(String lastName, String firstName, String email) {
        this.id = UUID.randomUUID();
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

    public User(UUID id, String lastName, String firstName, String email) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

}
