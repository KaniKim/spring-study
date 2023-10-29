package kani.spring.springkani.mappers;

import org.mapstruct.Mapper;

import kani.spring.springkani.entities.Customer;
import kani.spring.springkani.model.CustomerDTO;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    
    Customer customerDtoToCustomer(CustomerDTO dto);
    CustomerDTO customerToCustomerDTO(Customer customer);
}
