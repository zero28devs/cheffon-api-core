package com.cheffon.api.domain.tags.services.interfaces;

import com.cheffon.api.domain.tags.entities.Tag;
import com.cheffon.api.shared.exceptions.domain.EntidadeNaoEncontradaException;

public interface TagDomainService {

	Tag validar( Long id ) throws EntidadeNaoEncontradaException;
}
