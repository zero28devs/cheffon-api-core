package com.cheffon.api.application.services.action.interfaces;

import com.cheffon.api.domain.action.entities.Action;
import com.cheffon.api.domain.action.services.filtros.ListarActionFiltro;
import com.cheffon.api.shared.exceptions.application.RecursoNaoEncontradoException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ActionApplicationService {
    Action buscar(Long id) throws RecursoNaoEncontradoException;

    Page<Action> listar(Pageable dadosPaginacao, ListarActionFiltro filtro );

    Action cadastrar(Action action);

    Action editar(Long id, Action action);

    void excluir(Long id);
}
