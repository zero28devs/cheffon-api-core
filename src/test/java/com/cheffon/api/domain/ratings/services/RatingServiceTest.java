package com.cheffon.api.domain.ratings.services;

import com.cheffon.api.domain.rating.entities.Rating;
import com.cheffon.api.domain.rating.repositories.RatingRepository;
import com.cheffon.api.domain.rating.services.RatingService;
import com.cheffon.api.domain.ratings.factories.RatingFactory;

import com.cheffon.api.infra.repositories.ratings.RatingDatabaseRepository;
import com.cheffon.api.shared.exceptions.domain.EntidadeNaoEncontradaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;



class RatingServiceTest {

    private RatingRepository<Page<Rating>, Pageable> ratingRepository;
    private RatingService<Page<Rating>, Pageable> ratingService;
    private RatingFactory ratingFactory;

    @BeforeEach
    void setup(){
        ratingRepository = mock(RatingDatabaseRepository.class);
        ratingService = new RatingService<>(ratingRepository);
        ratingFactory = new RatingFactory();
    }

    @Test
    @DisplayName( "Quando validar com código válido espero Rating válido" )
    void quandoValidarComCodigoValidoEsperoRatingValido() throws EntidadeNaoEncontradaException {
        Rating rating = ratingFactory.gerarPadrao();
        when(ratingRepository.buscar(1L)).thenReturn(rating);
        Rating ratingRetornado = ratingService.validar(1L);
        assertEquals(rating, ratingRetornado);
    }

    @Test
    @DisplayName( "Quando validar com código não válido espero Rating válido" )
    void quandoValidarComCodigoInvalidoEsperoEntidadeNaoEncontrada(){
        when(ratingRepository.buscar(999L)).thenReturn(null);
        assertThrowsExactly(EntidadeNaoEncontradaException.class,() -> ratingService.validar(999L) );
    }

}
