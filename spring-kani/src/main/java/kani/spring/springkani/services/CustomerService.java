package kani.spring.springkani.services;

import java.util.List;
import java.util.UUID;

import kani.spring.springkani.model.Customer;

public interface CustomerService {
    Customer saveNewCustomer(Customer customer);
    void updateCustomerById(UUID customerId, Customer customer);
    void deleteById(UUID customerId);
    List<Customer> listCustomers();
    Customer getCustomerById(UUID id);
}
