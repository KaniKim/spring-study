package kani.spring.springkani.mappers;

import org.mapstruct.Mapper;

import kani.spring.springkani.entities.Beer;
import kani.spring.springkani.model.BeerDTO;

@Mapper(componentModel = "spring")
public interface BeerMapper {
    
    Beer beerDtoToBeer(BeerDTO beer);

    BeerDTO beerToBeerDTO(Beer beer);

}
