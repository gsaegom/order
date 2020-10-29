package com.switchfully.guillermo.order.services;

import com.switchfully.guillermo.order.domain.users.Admin;
import com.switchfully.guillermo.order.domain.users.Customer;
import com.switchfully.guillermo.order.exceptions.AdminPrivilegeException;
import com.switchfully.guillermo.order.repository.UserDatabase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CustomerService {

    private UserDatabase userDatabase;
    private ValidationService validationService;

    public CustomerService(UserDatabase userDatabase, ValidationService validationService) {
        this.userDatabase = userDatabase;
        this.validationService = validationService;
    }

    public void createCustomerAccount(Customer customer) {

        userDatabase.addCustomerAccount(customer);
    }

    public List<Customer> viewAllCustomers(String checkerId) {

        if (!validationService.isValidUUID(checkerId)) {
            throw new IllegalArgumentException("Invalid UUID ID.");
        }


        UUID adminId = UUID.fromString(checkerId);

        if (!userDatabase.userExists(adminId)) {
            throw new IllegalArgumentException("This user doesn't exist.");
        }

        if (userDatabase.getUserType(adminId) != Admin.class) {
            throw new AdminPrivilegeException("Only an admin can view all customers. In other words, computer says no.");
        }
        return userDatabase.viewAllCustomers();
    }

    //TODO: Use IDs either as UUID or String
    //TODO: Maybe create a customer database and an admin database?
    public Customer viewCustomer(String idToCheck, String checkerId) {
        if (!validationService.isValidUUID(checkerId)) {
            throw new IllegalArgumentException("Invalid UUID ID.");
        }

        UUID adminId = UUID.fromString(checkerId);
        UUID customerId = UUID.fromString(idToCheck);

        if (!userDatabase.userExists(adminId)) {
            throw new IllegalArgumentException("This user doesn't exist.");
        }

        if (userDatabase.getUserType(adminId) != Admin.class) {
            throw new AdminPrivilegeException("Only an admin can view a customer. In other words, computer says no.");
        }
        return userDatabase.viewCustomerById(customerId);
    }
}
