package com.cheffon.api.domain.action.repositories;

import com.cheffon.api.domain.action.entities.Action;
import com.cheffon.api.domain.action.services.filtros.ListarActionFiltro;

public interface ActionRepository<T,V>{
    Action buscar(Long id);
    T listar(V dadosPaginacao, ListarActionFiltro filtro);
    Action cadastrar(Action action);
    Action editar(Action action);
    void excluir(Long id);
}
