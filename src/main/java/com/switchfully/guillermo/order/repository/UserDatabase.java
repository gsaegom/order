package com.switchfully.guillermo.order.repository;

import com.switchfully.guillermo.order.domain.Admin;
import com.switchfully.guillermo.order.domain.Customer;
import com.switchfully.guillermo.order.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class UserDatabase {
    Map<UUID, User> userDatabase;

    public UserDatabase() {
        this.userDatabase = new HashMap<>();
    }

    public Map<UUID, User> getUserDatabase() {
        return userDatabase;
    }

    public Customer addCustomerAccount(Customer customer) {
        userDatabase.put(customer.getId(), customer);
        return (Customer) userDatabase.get(customer.getId());

    }

    public Admin addAdmin(Admin admin) {
        userDatabase.put(admin.getId(), admin);
        return (Admin) userDatabase.get(admin.getId());
    }

    public boolean userExists(UUID id) {
        return userDatabase.containsKey(id);
    }

    public Class<? extends User> getUserType(UUID creatorId) {
        return getUser(creatorId).getClass();
    }

    public User getUser(UUID id) {
        return userDatabase.get(id);
    }


}
