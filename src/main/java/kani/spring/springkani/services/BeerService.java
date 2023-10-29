package kani.spring.springkani.services;

import kani.spring.springkani.model.BeerDTO;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

public interface BeerService {
    BeerDTO saveNewBeer(BeerDTO beer);
    void patchBeerById(UUID beerId, BeerDTO beer);
    Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beer);
    boolean deleteById(UUID beerId);
    List<BeerDTO> listBeers();
    Optional<BeerDTO> getBeerById(UUID id);
}
