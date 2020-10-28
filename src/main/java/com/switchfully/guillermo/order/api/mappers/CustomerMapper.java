package com.switchfully.guillermo.order.api.mappers;

import com.switchfully.guillermo.order.api.dtos.CustomerDTO;
import com.switchfully.guillermo.order.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {


    public Customer convertCustomerDTOToCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO.getFirstName(),
                customerDTO.getLastName(), customerDTO.getEmailAddress(), customerDTO.getAddress(), customerDTO.getPhoneNumber());
        return customer;
    }
}
