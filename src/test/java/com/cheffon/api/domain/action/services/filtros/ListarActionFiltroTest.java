package com.cheffon.api.domain.action.services.filtros;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListarActionFiltroTest {
    @Test
    @DisplayName( "Quando getNome espero nome retornado" )
    void quandoGetNomeEsperoRetornoNome() {
        ListarActionFiltro filtro = new ListarActionFiltro();
        filtro.setNome( "Teste" );
        assertEquals("Teste", filtro.getNome());
    }

    @Test
    @DisplayName( "Quando setNome espero atribuição" )
    void quandoSetNomeEsperoAtribuicao() {
        ListarActionFiltro filtro = new ListarActionFiltro();
        filtro.setNome( "Action teste" );
        assertEquals("Action teste", filtro.getNome());
    }
}
