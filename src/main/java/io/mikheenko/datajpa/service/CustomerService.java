package io.mikheenko.datajpa.service;

import io.mikheenko.datajpa.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer getById(Long id);
    void save(Customer customer);
    void delete(Long id);
    List<Customer> getAll();
}
