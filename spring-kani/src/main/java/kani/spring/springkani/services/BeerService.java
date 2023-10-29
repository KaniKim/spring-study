package kani.spring.springkani.services;

import kani.spring.springkani.model.Beer;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

public interface BeerService {
    Beer saveNewBeer(Beer beer);
    void patchBeerById(UUID beerId, Beer beer);
    void updateBeerById(UUID beerId, Beer beer);
    void deleteById(UUID beerId);
    List<Beer> listBeers();
    Optional<Beer> getBeerById(UUID id);
}
