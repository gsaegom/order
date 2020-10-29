package com.switchfully.guillermo.order.repository;

import com.switchfully.guillermo.order.domain.users.Admin;
import com.switchfully.guillermo.order.domain.users.Customer;
import com.switchfully.guillermo.order.domain.users.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class UserDatabase {
    private Map<UUID, User> userDatabase;

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


    public List<Customer> viewAllCustomers() {
        return userDatabase.values().stream()
                .filter(user -> user.getClass().equals(Customer.class))
                .map(customer -> (Customer) customer)
                .collect(Collectors.toList());
    }

    public Customer viewCustomerById(UUID id) {
        if (getUserType(id).equals(Customer.class)) {
            return (Customer) userDatabase.get(id);
        } else throw new IllegalArgumentException("This user is not a customer");
    }
}
