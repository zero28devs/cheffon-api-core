package com.cheffon.api.domain.ratings.entities;

import com.cheffon.api.domain.rating.entities.Rating;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RatingTest {

    @Test
    @DisplayName("Quando construtor criado espero atribuição")
    void quandoConstrutorCriadoEsperoAtribuicao(){
        Rating rating = new Rating(1.0);
        assertEquals(1.0, rating.getScore());
    }

    @Test
    @DisplayName("Quando setId espero atribuição")
    void quandoSetIdEsperoAtribuicao(){
        Rating rating = new Rating(1.0);
        rating.setId(1L);
        assertEquals(1L, rating.getId());
    }

    @Test
    @DisplayName("Quando setScore espero atribuição")
    void quandoSetScoreEsperoAtribuicao(){
        Rating rating = new Rating(1.0);
        rating.setId(1L);
        rating.setScore(2.0);
        assertEquals(2.0, rating.getScore());
    }

    @Test
    @DisplayName("Quando equals valido espero sucesso")
    void quandoEqualsValidoEsperoSucesso(){
        EqualsVerifier.simple().forClass(Rating.class).verify();
    }

    @Test
    @DisplayName("Quando toString espero valor válido")
    void quandoToStringEsperoValorValido(){
        Rating rating = new Rating(1.0);
        assertEquals("Rating{id=null, score=1.0}", rating.toString());
    }
}

