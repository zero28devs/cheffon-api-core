package com.cheffon.api.domain.tags.services.interfaces;

import com.cheffon.api.domain.tags.entities.Tag;
import com.cheffon.api.shared.exceptions.domain.AtributoInvalidoException;
import com.cheffon.api.shared.exceptions.domain.EntidadeNaoEncontradaException;

public interface TagUseCase {
	Tag Instanciar(String nome) throws AtributoInvalidoException;
	Tag Validar(Long codigo) throws EntidadeNaoEncontradaException;
}
