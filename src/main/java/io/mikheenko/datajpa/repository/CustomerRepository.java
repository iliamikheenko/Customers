package io.mikheenko.datajpa.repository;

import io.mikheenko.datajpa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for {@link Customer} class
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}