package com.cheffon.api.domain.tags.services;

import com.cheffon.api.domain.tags.entities.Tag;
import com.cheffon.api.domain.tags.repositories.TagRepository;
import com.cheffon.api.domain.tags.services.interfaces.TagUseCase;
import com.cheffon.api.shared.exceptions.domain.AtributoInvalidoException;
import com.cheffon.api.shared.exceptions.domain.EntidadeNaoEncontradaException;

public class TagService implements TagUseCase {
	private final TagRepository tagRepository;

	public TagService( TagRepository tagRepository ) {
		this.tagRepository = tagRepository;
	}

	@Override
	public Tag Instanciar( String nome ) throws AtributoInvalidoException {
		return new Tag( nome );
	}

	@Override
	public Tag Validar( Long codigo ) throws EntidadeNaoEncontradaException {
		Tag tag = tagRepository.buscarPorCodigo( codigo );
		if (tag == null)
			throw new EntidadeNaoEncontradaException( Tag.class );
		return tag;
	}
}
