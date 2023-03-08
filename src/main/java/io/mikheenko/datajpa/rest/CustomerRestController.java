package io.mikheenko.datajpa.rest;

import io.mikheenko.datajpa.model.Customer;
import io.mikheenko.datajpa.service.CustomerService;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/customers/")
public class CustomerRestController {
    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long customerId){
        if (customerId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var customer = customerService.getById(customerId);
        if (customer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        return new ResponseEntity<>(customer, HttpStatus.OK);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customer);
    }
    @PostMapping(value = "",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        HttpHeaders headers = new HttpHeaders();
        if (customer == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.customerService.save(customer);
        return new ResponseEntity<>(customer,headers,HttpStatus.CREATED);
    }
    @PutMapping(value = "",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, UriComponentsBuilder builder){
        HttpHeaders headers = new HttpHeaders();
        if (customer == null){
            return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
        }
        this.customerService.save(customer);
        return new ResponseEntity<>(customer,headers,HttpStatus.OK);
    }
    @DeleteMapping(value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id){
        var customer = this.customerService.getById(id);
        if (customer == null){
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        this.customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getAllCustomers(){
        var customers = this.customerService.getAll();
        if (customers == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }
}
