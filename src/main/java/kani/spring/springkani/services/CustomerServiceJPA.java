package kani.spring.springkani.services;

import kani.spring.springkani.mappers.CustomerMapper;
import kani.spring.springkani.model.CustomerDTO;
import kani.spring.springkani.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Primary
@RequiredArgsConstructor
@Service
public class CustomerServiceJPA implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public Optional<CustomerDTO> patchCustomerById(UUID customerId, CustomerDTO customer) {
        AtomicReference<Optional<CustomerDTO>> atomicReference = new AtomicReference<>();

        customerRepository.findById(customerId).ifPresentOrElse(foundCustomer -> {
            if(StringUtils.hasText(customer.getName())) {
                foundCustomer.setName(customer.getName());
            }
            atomicReference.set(Optional.of(
                customerMapper.customerToCustomerDTO(
                    customerRepository.save(foundCustomer)
                    )
                )
            );
        }, () -> {
            atomicReference.set(Optional.empty());
        });

        return atomicReference.get();
    }

    @Override
    public boolean deleteById(UUID customerId) {
        if(customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
            
            return true;
        }
        return false;

    }

    @Override
    public Optional<CustomerDTO> updateCustomerById(UUID customerId, CustomerDTO customer) {
        AtomicReference<Optional<CustomerDTO>> atomicReference = new AtomicReference<>();

        customerRepository.findById(customerId).ifPresentOrElse(foundCustomer -> {
            foundCustomer.setName(customer.getName());
            atomicReference.set(Optional.of(
                customerMapper.customerToCustomerDTO(
                    customerRepository.save(foundCustomer))
                )
            );
        }, () -> {
            atomicReference.set(Optional.empty());
        });

        return atomicReference.get();
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customer) {
        return customerMapper.customerToCustomerDTO(
                customerRepository.save(
                    customerMapper.customerDtoToCustomer(customer)
                )
            );
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
