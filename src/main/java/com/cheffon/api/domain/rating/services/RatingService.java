package com.cheffon.api.domain.rating.services;

import com.cheffon.api.domain.rating.entities.Rating;
import com.cheffon.api.domain.rating.repositories.RatingRepository;
import com.cheffon.api.domain.rating.services.interfaces.RatingDomainService;
import com.cheffon.api.shared.exceptions.domain.EntidadeNaoEncontradaException;

public final class RatingService<V,T> implements RatingDomainService {

    private final RatingRepository<V,T> ratingRepository;

    public RatingService(RatingRepository<V,T> ratingRepository){this.ratingRepository = ratingRepository;}

    @Override
    public Rating validar(Long id) throws EntidadeNaoEncontradaException {
        Rating rating = ratingRepository.buscar(id);
        if(rating == null)
            throw new EntidadeNaoEncontradaException(Rating.class);
        return rating;
    }
}
