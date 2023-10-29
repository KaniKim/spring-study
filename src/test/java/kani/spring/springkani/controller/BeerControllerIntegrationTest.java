package kani.spring.springkani.controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import kani.spring.springkani.model.BeerDTO;
import kani.spring.springkani.repositories.BeerRepository;

@ActiveProfiles("test")
@SpringBootTest
class BeerControllerIntegrationTest {

    @Autowired
    BeerRepository beerRepository;

    @Autowired
    BeerController beerController;

    @Test
    void testListBeers() {
        List<BeerDTO> dtos = beerController.listBeers();

        assertThat(dtos.size()).isEqualTo(3);
    }
}
