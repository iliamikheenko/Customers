package io.mikheenko.datajpa.service;

import io.mikheenko.datajpa.model.Customer;
import io.mikheenko.datajpa.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer getById(Long id) {
        log.info("IN CustomerServiceImpl getByID {}", id);
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        log.info("IN CustomerServiceImpl save {}", customer);
        customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        log.info("IN CustomerServiceImpl delete {}", id);
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAll() {
        log.info("IN CustomerServiceImpl getAll");
        return customerRepository.findAll();
    }
}
