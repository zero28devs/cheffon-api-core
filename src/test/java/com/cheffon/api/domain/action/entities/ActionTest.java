package com.cheffon.api.domain.action.entities;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ActionTest {

    @Test
    @DisplayName( "Quando construtor criado espero atribuição" )
    void quandoConstrutorCriadoEsperoAtribuicao(){
        Action action = new Action("teste");
        assertEquals("teste",action.getNome());
    }

    @Test
    @DisplayName( "Quando setId espero atribuição" )
    void quandoSetIdEsperoAtribuicao() {
        Action action = new Action("teste");
        action.setId(1L);
        assertEquals(1L, action.getId());
    }

    @Test
    @DisplayName( "Quando equals valido espero sucesso" )
    void quandoEqualsValidoEsperoSucesso() {
        EqualsVerifier.simple().forClass( Action.class ).verify();
    }

    @Test
    @DisplayName( "Quando toString espero valor válido" )
    void quandoToStringEsperoValorValido() {
        Action action = new Action("teste");
        assertEquals("Action{id=null, nome='teste'}", action.toString());
    }
}
