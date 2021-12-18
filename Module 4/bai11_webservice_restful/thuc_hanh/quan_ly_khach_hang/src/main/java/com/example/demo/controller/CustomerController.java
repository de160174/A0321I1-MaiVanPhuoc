package com.example.demo.controller;


import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getList(){
        List<Customer> customers=customerService.findAll();
        if(customers.isEmpty()){
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }
    @GetMapping(value = "/customer/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id){
        System.out.println("Fetching Customer with id" + id);
        Customer customer=customerService.findById(id);
        if(customer==null){
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer,HttpStatus.OK);
    }
    @PostMapping("create")
    public ResponseEntity<Void> create(@RequestBody Customer customer, UriComponentsBuilder builder){
        System.out.println("Creating Customer " + customer.getLastName());
        customerService.save(customer);
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(builder.path("update/{id}").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id,@RequestBody Customer customer){
        System.out.println("Updating Customer " + id);
        Customer c=customerService.findById(id);
        if(c==null){
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        c.setFirstName(customer.getFirstName());
        c.setLastName(customer.getLastName());
        c.setId(customer.getId());
        customerService.save(c);
        return new ResponseEntity<Customer>(c,HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Customer> delete(@PathVariable Long id){
        System.out.println("Fetching & Deleting Customer with id " + id);

        Customer customer = customerService.findById(id);
        if (customer == null) {
            System.out.println("Unable to delete. Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        customerService.remove(id);
        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
    }
}
