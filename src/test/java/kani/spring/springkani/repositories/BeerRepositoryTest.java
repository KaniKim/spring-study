package kani.spring.springkani.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import jakarta.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import kani.spring.springkani.entities.Beer;
import kani.spring.springkani.model.BeerStyle;

@ActiveProfiles("test")
@DataJpaTest
class BeerRepositoryTest {
    
    @Autowired
    BeerRepository beerRepository;

    @Test
    void testSaveBeerTooLongName() {

        assertThrows(ConstraintViolationException.class, () -> {
            Beer savedBeer = beerRepository.save(Beer.builder()
                                    .name("My beer 12345123451234512345123451234512345123451234512345123451234512345123451234512345123451234512345")
                                    .beerStyle(BeerStyle.ALE)
                                    .upc("23452345")
                                    .price(new BigDecimal("11.99"))
                                .build());
            beerRepository.flush();
        });
    }

    @Test
    void testSaveBeer() {
        Beer savedBeer = beerRepository.save(Beer.builder()
                                    .name("My beer")
                                    .beerStyle(BeerStyle.ALE)
                                    .upc("23452345")
                                    .price(new BigDecimal("11.99"))
                                .build());
        beerRepository.flush();

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }
}
