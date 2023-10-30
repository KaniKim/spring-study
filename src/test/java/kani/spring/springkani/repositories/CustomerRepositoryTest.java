package kani.spring.springkani.repositories;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import jakarta.validation.ConstraintViolationException;
import kani.spring.springkani.entities.Beer;
import kani.spring.springkani.entities.Customer;
import kani.spring.springkani.model.BeerStyle;

@ActiveProfiles("test")
@DataJpaTest
class CustomerRepositoryTest {
    
    @Autowired
    CustomerRepository customerRepository;

    @Test
    void testSaveCustomerTooLongName() {

        assertThrows(ConstraintViolationException.class, () -> {
            Customer savedCustomer = customerRepository.save(Customer.builder()
                                    .name("My customer 12345123451234512345123451234512345123451234512345123451234512345123451234512345123451234512345")
                                .build());
            customerRepository.flush();
        });
    }

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
