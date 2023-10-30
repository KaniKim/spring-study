package kani.spring.springkani.services;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

import kani.spring.springkani.model.CustomerDTO;

public interface CustomerService {
    CustomerDTO saveNewCustomer(CustomerDTO customer);
    Optional<CustomerDTO> updateCustomerById(UUID customerId, CustomerDTO customer);
    boolean deleteById(UUID customerId);
    Optional<CustomerDTO> patchCustomerById(UUID customerId, CustomerDTO customer);
    List<CustomerDTO> listCustomers();
    Optional<CustomerDTO> getCustomerById(UUID id);
}
