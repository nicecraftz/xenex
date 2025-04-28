package it.alessandrocalista.xenex.mapper;

import it.alessandrocalista.xenex.dto.CustomerDTO;
import it.alessandrocalista.xenex.entity.Customer;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerMapper {

    public static CustomerDTO toDTO(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getEmail()
        );
    }

    public static Customer toEntity(CustomerDTO customerDTO) {
        return new Customer(
                customerDTO.id(),
                customerDTO.name(),
                customerDTO.email()
        );
    }

}
