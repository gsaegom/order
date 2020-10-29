package com.switchfully.guillermo.order.api.mappers;

import com.switchfully.guillermo.order.api.dtos.CustomerDTO;
import com.switchfully.guillermo.order.domain.users.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {


    public Customer convertCustomerDTOToCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO.getFirstName(),
                customerDTO.getLastName(), customerDTO.getEmailAddress(), customerDTO.getAddress(), customerDTO.getPhoneNumber());
        return customer;
    }

    public List<CustomerDTO> convertMemberListToMemberDtoList(List<Customer> customerList) {
        return customerList.stream()
                .map(customer -> new CustomerDTO(customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getAddress(), customer.getPhoneNumber()))
                .collect(Collectors.toList());
    }
}
