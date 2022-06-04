package com.cheffon.api.domain.action.services;

import com.cheffon.api.domain.action.entities.Action;

import com.cheffon.api.domain.action.repositories.ActionRepository;
import com.cheffon.api.domain.action.services.interfaces.ActionDomainService;
import com.cheffon.api.shared.exceptions.domain.EntidadeNaoEncontradaException;

public final class ActionService<V, T> implements ActionDomainService {

    private final ActionRepository<V, T> actionRepository;

    public ActionService(ActionRepository<V, T> actionRepository) {
        this.actionRepository = actionRepository;
    }

    @Override
    public Action validar(Long id) throws EntidadeNaoEncontradaException {
        Action action = actionRepository.buscar(id);
        if (action == null) {
            throw new EntidadeNaoEncontradaException(Action.class);
        }
        return action;
    }
}
