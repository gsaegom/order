package com.switchfully.guillermo.order.api.controllers;


import com.switchfully.guillermo.order.api.dtos.CustomerDTO;
import com.switchfully.guillermo.order.api.mappers.CustomerMapper;
import com.switchfully.guillermo.order.domain.users.Customer;
import com.switchfully.guillermo.order.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createCustomerAccount(@RequestBody CustomerDTO customerDTO) {
        LOGGER.info("Request to register a customer account");
        Customer customer = customerMapper.convertCustomerDTOToCustomer(customerDTO);
        customerService.createCustomerAccount(customer);
        return customerDTO;
    }

    @GetMapping
    public List<CustomerDTO> getAllMembers(@RequestHeader String id) {
        List<Customer> allCustomers = customerService.getAllCustomers(id);
        return customerMapper.convertMemberListToMemberDtoList(allCustomers);
    }
}
