package com.cheffon.api.domain.action.services.interfaces;

import com.cheffon.api.domain.action.entities.Action;
import com.cheffon.api.shared.exceptions.domain.EntidadeNaoEncontradaException;

public interface ActionDomainService {
    Action validar(Long id) throws EntidadeNaoEncontradaException;
}
