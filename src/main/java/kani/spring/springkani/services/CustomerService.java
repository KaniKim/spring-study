package kani.spring.springkani.services;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

import kani.spring.springkani.model.CustomerDTO;

public interface CustomerService {
    CustomerDTO saveNewCustomer(CustomerDTO customer);
    void updateCustomerById(UUID customerId, CustomerDTO customer);
    void deleteById(UUID customerId);
    void patchCustomerById(UUID customerId, CustomerDTO customer);
    List<CustomerDTO> listCustomers();
    Optional<CustomerDTO> getCustomerById(UUID id);
}
