package kani.spring.springkani.services;

import kani.spring.springkani.mappers.CustomerMapper;
import kani.spring.springkani.model.CustomerDTO;
import kani.spring.springkani.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;
import java.util.UUID;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@RequiredArgsConstructor
@Service
public class CustomerServiceJPA implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public void patchCustomerById(UUID customerId, CustomerDTO customer) {

    }

    @Override
    public void deleteById(UUID customerId) {
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerDTO customer) {
    
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customer) {
        return null;
    }

    @Override
    public List<CustomerDTO> listCustomers() {
        return customerRepository.findAll()
                    .stream()
                    .map(customerMapper::customerToCustomerDTO)
                    .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID id) {
        return Optional.ofNullable(
            customerMapper.customerToCustomerDTO(
                customerRepository.findById(id).orElse(null)));
    }


}
