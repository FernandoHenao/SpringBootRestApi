package com.example.demo.controller;

import lombok.AllArgsConstructor;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/customers")
public class CustomerController {

    private CustomerService customerService;

    // build create  REST API
    @PostMapping("/save")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer savedCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    //hi
    // build get customer by id REST API
    // http://localhost:8080/api/customers/1
    @GetMapping("/findById/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long customerId){
        Customer customer = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    // Build Get All Customers REST API
    // http://localhost:8080/api/customers
    @GetMapping("/findAll")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    // Build Update Customer REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/customers/1
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long customerId,
                                             @RequestBody Customer customer){
        customer.setCustomer_id(customerId);
        Customer updatedCustomer = customerService.updateCustomer(customer);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    // Build Delete Customer REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long customerId){
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>("Customer successfully deleted!", HttpStatus.OK);
    }
}