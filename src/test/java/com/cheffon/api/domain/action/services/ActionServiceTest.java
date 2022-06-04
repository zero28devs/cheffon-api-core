package com.cheffon.api.domain.action.services;

import com.cheffon.api.domain.action.entities.Action;
import com.cheffon.api.domain.action.factories.ActionFactory;
import com.cheffon.api.domain.action.repositories.ActionRepository;
import com.cheffon.api.infra.repositories.action.ActionDatabaseRepository;
import com.cheffon.api.shared.exceptions.domain.EntidadeNaoEncontradaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ActionServiceTest {

    private ActionRepository<Page<Action>, Pageable> actionRepository;
    private ActionService<Page<Action>, Pageable> actionService;
    private ActionFactory actionFactory;

    @BeforeEach
    void setup(){
        actionRepository = mock(ActionDatabaseRepository.class);
        actionService = new ActionService<>(actionRepository);
        actionFactory = new ActionFactory();
    }

    @Test
    @DisplayName( "Quando validar com código válido espero Action válida" )
    void quandoValidarComCodigoValidoEsperoActionValida() throws EntidadeNaoEncontradaException {
        Action action = actionFactory.gerarPadrao();
        when(actionRepository.buscar(1L)).thenReturn(action);
        Action actionRetornada = actionService.validar(1L);
        assertEquals( action, actionRetornada );
    }

    @Test
    @DisplayName( "Quando validar com código não existente espero EntidadeNaoEncontradaException" )
    void quandoValidarComCodigoInvalidoEsperoEntidadeNaoEncontrada() {
        when( actionRepository.buscar( 999L ) ).thenReturn( null );
        assertThrowsExactly( EntidadeNaoEncontradaException.class, () -> actionService.validar( 999L ) );
    }
}
