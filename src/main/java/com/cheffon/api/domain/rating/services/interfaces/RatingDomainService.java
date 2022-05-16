package com.cheffon.api.domain.rating.services.interfaces;

import com.cheffon.api.domain.rating.entities.Rating;
import com.cheffon.api.shared.exceptions.domain.EntidadeNaoEncontradaException;

public interface RatingDomainService {
    Rating validar(Long id) throws EntidadeNaoEncontradaException;
}
