package kani.spring.springkani.controller;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import kani.spring.springkani.controller.exception.NotFoundException;
import kani.spring.springkani.entities.Customer;
import kani.spring.springkani.model.CustomerDTO;
import kani.spring.springkani.repositories.CustomerRepository;

@ActiveProfiles("test")
@SpringBootTest
public class CustomerControllerIntegrationTest {
    
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerController customerController;

    @Test
    void testCustomerIdNotFound() {
        assertThrows(NotFoundException.class, () -> {
            customerController.getCustomerById(UUID.randomUUID());
        });
    }

    @Test
    void testGetById() {
        Customer customer = customerRepository.findAll().get(0);
        
        CustomerDTO dto = customerController.getCustomerById(customer.getId());

        assertThat(dto).isNotNull();
    }

    @Test
    void testListCustomers() {
        List<CustomerDTO> dtos = customerController.listCustomers();

        assertThat(dtos.size()).isEqualTo(3);
    }
}
