package kani.spring.springkani.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Builder
@Data
public class BeerDTO {
    private UUID id;
    private Integer version;
    private String name;
    private BeerStyle beerStyle;
    private String upc;
    private Integer quantityOnHand;
    private BigDecimal price;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}
