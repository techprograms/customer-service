package com.gpr.customer_service.service;

import com.gpr.customer_service.client.MovieClient;
import com.gpr.customer_service.dto.CustomerDto;
import com.gpr.customer_service.dto.GenreUpdateRequest;
import com.gpr.customer_service.exceptions.CustomerNotFoundException;
import com.gpr.customer_service.mapper.EntityDtoMapper;
import com.gpr.customer_service.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final MovieClient movieClient;
    private final CustomerRepository repository;

    public CustomerService(MovieClient movieClient, CustomerRepository repository) {
        this.movieClient = movieClient;
        this.repository = repository;
    }

    public CustomerDto getCustomer(Integer id) {
        var customer = this.repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        var movies = this.movieClient.getMovies(customer.getFavoriteGenre());
        return EntityDtoMapper.toDto(customer, movies);
    }

    public void updateCustomerGenre(Integer id, GenreUpdateRequest request) {
        var customer = this.repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        customer.setFavoriteGenre(request.favoriteGenre());
        this.repository.save(customer);
    }

}
