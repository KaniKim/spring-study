package kani.spring.springkani.services;

import kani.spring.springkani.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    Beer saveNewBeer(Beer beer);
    List<Beer> listBeers();
    Beer getBeerById(UUID id);
}
