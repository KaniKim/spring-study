package kani.spring.springkani.services;

import kani.spring.springkani.model.Beer;

import java.util.UUID;

public interface BeerService {

    Beer getBeerById(UUID id);
}
