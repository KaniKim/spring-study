package kani.spring.springkani.repositories;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import kani.spring.springkani.entities.Customer;

@ActiveProfiles("test")
@DataJpaTest
class CustomerRepositoryTest {
    
    @Autowired
    CustomerRepository customerRepository;

    @Test
    void testSaveCustomer() {
        Customer customer = customerRepository.save(
                                            Customer.builder()
                                            .name("New Name")
                                            .build());
        
        assertThat(customer.getId()).isNotNull();
        assertThat(customer.getName()).isEqualTo("New Name");
    }
}
