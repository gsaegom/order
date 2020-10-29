package com.switchfully.guillermo.order.services;

import com.switchfully.guillermo.order.domain.users.Admin;
import com.switchfully.guillermo.order.domain.users.Customer;
import com.switchfully.guillermo.order.exceptions.AdminPrivilegeException;
import com.switchfully.guillermo.order.repository.UserDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class CustomerServiceTest {
    @Test
    void givenNecessaryInformation_ICanCreateNewCustomerAccount() {
        UserDatabase userDatabase = new UserDatabase();
        Customer customer = new Customer("John", "Doe", "john@doe.com", "123 Fake St.", "041304123");
        userDatabase.addCustomerAccount(customer);
        Assertions.assertEquals(userDatabase.getUser(customer.getId()),customer);
    }

    @Test
    void givenListOfCustomers_whenAdminChecks_CustomersAreReturned() {
        UserDatabase userDatabase = new UserDatabase();
        ValidationService validationService = new ValidationService();
        CustomerService customerService = new CustomerService(userDatabase, validationService);
        Admin admin = new Admin(UUID.fromString("96e35a5e-bdbd-492b-aafb-8b9d2c6e96b9"), "admin", "admin", "admin@admin.com");
        userDatabase.addAdmin(admin);
        Customer customer = new Customer("Doe", "John", "johndoe@gmail.com", "123 Fake St","0012938109283");
        Customer customer2 = new Customer("Doe2", "John2", "johndoe2@gmail.com", "100 Real St","01934091820398123");
        customerService.createCustomerAccount(customer2);
        customerService.createCustomerAccount(customer);
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        customerList.add(customer2);

        // DO NOT CHECK DIRECTLY AS LIST! The reason is: UserDatabase is stored as a HashMap and when we convert the values to a list it's not always ordered
        // as we would expect. So we'd either need to implement a comparator OR just do .containsAll(your_list)

        Assertions.assertTrue(customerService.getAllCustomers("96e35a5e-bdbd-492b-aafb-8b9d2c6e96b9").containsAll(customerList));
    }

    @Test
    void givenListOfMembers_whenSomeoneOtherThanAdminChecks_ThrowAdminPrivilegeException() {
        UserDatabase userDatabase = new UserDatabase();
        ValidationService validationService = new ValidationService();
        CustomerService customerService = new CustomerService(userDatabase, validationService);
        Customer notAnAdmin = new Customer(UUID.fromString("1f8767ee-e926-4b5a-bcdd-cb6aa3c04c21"), "Smith", "Jane", "jane@smith.com", "50 Nice St", "020394823049");
        userDatabase.addCustomerAccount(notAnAdmin);
        Customer customer = new Customer("Doe", "John", "johndoe@gmail.com", "123 Fake St","0012938109283");
        Customer customer2 = new Customer("Doe2", "John2", "johndoe2@gmail.com", "100 Real St","01934091820398123");
        customerService.createCustomerAccount(customer2);
        customerService.createCustomerAccount(customer);
        Assertions.assertThrows(AdminPrivilegeException.class, () -> customerService.getAllCustomers("1f8767ee-e926-4b5a-bcdd-cb6aa3c04c21"));
    }
    @Test
    void givenListOfMembers_whenCheckersIdDoesntExist_ThrowIllegalArgumentException() {
        UserDatabase userDatabase = new UserDatabase();
        ValidationService validationService = new ValidationService();
        CustomerService customerService = new CustomerService(userDatabase, validationService);
        Customer customer = new Customer("Doe", "John", "johndoe@gmail.com", "123 Fake St","0012938109283");
        Customer customer2 = new Customer("Doe2", "John2", "johndoe2@gmail.com", "100 Real St","01934091820398123");
        customerService.createCustomerAccount(customer2);
        customerService.createCustomerAccount(customer);
        Assertions.assertThrows(IllegalArgumentException.class, () -> customerService.getAllCustomers("1f8767ee-e926-4b5a-bcdd-cb6aa3c0"));
    }
}