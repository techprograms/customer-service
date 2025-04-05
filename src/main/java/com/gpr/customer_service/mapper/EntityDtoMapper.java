package com.gpr.customer_service.mapper;

import com.gpr.customer_service.dto.CustomerDto;
import com.gpr.customer_service.dto.MovieDto;
import com.gpr.customer_service.entity.Customer;

import java.util.List;

public class EntityDtoMapper {

    public static CustomerDto toDto(Customer customer, List<MovieDto> movies) {
        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getFavoriteGenre(),
                movies
        );
    }

}
