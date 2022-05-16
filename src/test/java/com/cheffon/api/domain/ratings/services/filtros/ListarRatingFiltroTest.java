package com.cheffon.api.domain.ratings.services.filtros;

import com.cheffon.api.domain.rating.services.filtros.ListarRatingFiltro;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ListarRatingFiltroTest {

    @Test
    @DisplayName("Quando getScore espero score retornado")
    void quandoGetScoreEsperoRetornoScore(){
        ListarRatingFiltro filtro = new ListarRatingFiltro();
        filtro.setScore(1.0);
        assertEquals(1.0, filtro.getScore());
    }

    @Test
    @DisplayName("Quando getScore espero score retornado")
    void quandosetScoreEsperoAtribuicaoScore(){
        ListarRatingFiltro filtro = new ListarRatingFiltro();
        filtro.setScore(2.0);
        assertEquals(2.0, filtro.getScore());
    }
}
