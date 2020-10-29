package com.switchfully.guillermo.order.domain.users;

import com.switchfully.guillermo.order.domain.users.User;

import java.util.UUID;

public class Admin extends User {
    public Admin(UUID id, String lastName, String firstName, String email) {
        super(id, lastName, firstName, email);
    }

    public Admin(String lastName, String firstName, String email) {
        super(lastName, firstName, email);
    }
}
