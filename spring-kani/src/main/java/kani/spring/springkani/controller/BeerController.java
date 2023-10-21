package kani.spring.springkani.controller;

import org.springframework.stereotype.Controller;

import kani.spring.springkani.model.Beer;
import kani.spring.springkani.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Controller
public class BeerController {
    private final BeerService beerService;

    public Beer getBeerById(UUID id) {
        log.debug("Get Beer by ID - in controller");
        
        return beerService.getBeerById(id);
    }

}
