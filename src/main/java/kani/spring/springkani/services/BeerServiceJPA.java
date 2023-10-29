package kani.spring.springkani.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import kani.spring.springkani.mappers.BeerMapper;
import kani.spring.springkani.model.BeerDTO;
import kani.spring.springkani.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Primary
@RequiredArgsConstructor
@Service
public class BeerServiceJPA implements BeerService{
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public void updateBeerById(UUID beerId, BeerDTO beer) {
    
    }

    @Override
    public void deleteById(UUID beerId) {

    }

    @Override
    public void patchBeerById(UUID beerId, BeerDTO beer) {
        
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beer) {
        return null;
    }

    @Override
    public List<BeerDTO> listBeers() {
        return beerRepository.findAll()
                .stream()
                .map(beerMapper::beerToBeerDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public Optional<BeerDTO> getBeerById(UUID id) {
        return Optional.ofNullable(
            beerMapper.beerToBeerDTO(
                beerRepository.findById(id).orElse(null)));
    }
}
