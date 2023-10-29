package kani.spring.springkani.bootstrap;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import kani.spring.springkani.repositories.BeerRepository;
import kani.spring.springkani.repositories.CustomerRepository;

@DataJpaTest
@ActiveProfiles("test")
class BootstrapDataTest {
    
    @Autowired
    BeerRepository beerRepository;

    @Autowired
    CustomerRepository customerRepository;

    BootstrapData bootstrapData;

    @BeforeEach
    void setup() {
        bootstrapData = new BootstrapData(beerRepository, customerRepository);
    }

    @Test
    void TestRun() throws Exception {
        bootstrapData.run();

        assertThat(beerRepository.count()).isEqualTo(3);
        assertThat(customerRepository.count()).isEqualTo(3);
    }
}
