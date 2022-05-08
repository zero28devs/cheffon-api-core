package com.cheffon.api.domain.tags.services;

import com.cheffon.api.domain.tags.repositories.TagRepository;
import com.cheffon.api.domain.tags.services.interfaces.TagDomainService;
import com.cheffon.api.domain.tags.entities.Tag;
import com.cheffon.api.shared.exceptions.domain.EntidadeNaoEncontradaException;

public final class TagService<V, T> implements TagDomainService {

	private final TagRepository<V, T> tagRepository;

	public TagService( TagRepository<V, T> tagRepository ) {
		this.tagRepository = tagRepository;
	}

	@Override
	public Tag Validar( Long id ) throws EntidadeNaoEncontradaException {
		Tag tag = tagRepository.buscar( id );
		if( tag == null )
			throw new EntidadeNaoEncontradaException( Tag.class );
		return tag;
	}
}
