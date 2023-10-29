package kani.spring.springkani.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import kani.spring.springkani.mappers.BeerMapper;
import kani.spring.springkani.model.BeerDTO;
import kani.spring.springkani.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
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
    public Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beer) {
        AtomicReference<Optional<BeerDTO>> atomicReference = new AtomicReference<>();
        
        beerRepository.findById(beerId).ifPresentOrElse(foundBeer -> {
            foundBeer.setName(beer.getName());
            foundBeer.setBeerStyle(beer.getBeerStyle());
            foundBeer.setUpc(beer.getUpc());
            foundBeer.setPrice(beer.getPrice());
            atomicReference.set(Optional.of(beerMapper
                    .beerToBeerDTO(beerRepository.save(foundBeer))));
        }, () -> {
            atomicReference.set(Optional.empty());
        });

        return atomicReference.get();
    }

    @Override
    public boolean deleteById(UUID beerId) {
        if (beerRepository.existsById(beerId)) {
            beerRepository.deleteById(beerId);
            
            return true;
        }
        return false;
    }

    @Override
    public void patchBeerById(UUID beerId, BeerDTO beer) {
        
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beer) {
        return beerMapper.beerToBeerDTO(
            beerRepository.save(
                beerMapper.beerDtoToBeer(beer)
            )
        );
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
