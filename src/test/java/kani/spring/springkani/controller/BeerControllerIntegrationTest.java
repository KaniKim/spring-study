package kani.spring.springkani.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import jakarta.transaction.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.UUID;

import kani.spring.springkani.controller.exception.NotFoundException;
import kani.spring.springkani.entities.Beer;
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
    void testBeerIdNotFound() {
        assertThrows(NotFoundException.class, () -> {
            beerController.getBeerById(UUID.randomUUID());
        });
    }

    @Test
    void testGetById() {
        Beer beer = beerRepository.findAll().get(0);

        BeerDTO dto = beerController.getBeerById(beer.getId());

        assertThat(dto).isNotNull();
    }

    @Test
    void testListBeers() {
        List<BeerDTO> dtos = beerController.listBeers();

        assertThat(dtos.size()).isEqualTo(3);
    }

    @Rollback
    @Transactional
    @Test
    void testEmptyList() {
        beerRepository.deleteAll();
        List<BeerDTO> dtos = beerController.listBeers();

        assertThat(dtos.size()).isEqualTo(0);
    }
}
