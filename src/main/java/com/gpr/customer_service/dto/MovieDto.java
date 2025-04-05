package com.gpr.customer_service.dto;


import com.gpr.customer_service.domain.Genre;

public record MovieDto(Integer id,
                       String title,
                       Integer releaseYear,
                       Genre genre) {
}
