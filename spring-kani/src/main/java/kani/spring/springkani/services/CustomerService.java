package kani.spring.springkani.services;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

import kani.spring.springkani.model.Customer;

public interface CustomerService {
    Customer saveNewCustomer(Customer customer);
    void updateCustomerById(UUID customerId, Customer customer);
    void deleteById(UUID customerId);
    void patchCustomerById(UUID customerId, Customer customer);
    List<Customer> listCustomers();
    Optional<Customer> getCustomerById(UUID id);
}
