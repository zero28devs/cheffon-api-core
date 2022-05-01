package com.cheffon.api.application.services.tags;

import com.cheffon.api.application.services.tags.interfaces.TagApplicationService;
import com.cheffon.api.domain.tags.entities.Tag;
import com.cheffon.api.domain.tags.repositories.TagRepository;
import com.cheffon.api.domain.tags.services.filtros.ListarTagFiltro;
import com.cheffon.api.shared.exceptions.application.RecursoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TagAppService implements TagApplicationService {

	private final TagRepository<Page<Tag>, Pageable> tagRepository;

	@Autowired
	public TagAppService( TagRepository<Page<Tag>, Pageable> tagRepository ) {
		this.tagRepository = tagRepository;
	}

	@Override
	public Tag buscar( Long id ) throws RecursoNaoEncontradoException {
		Tag tag = tagRepository.buscar( id );
		if( tag == null )
			throw new RecursoNaoEncontradoException( Tag.class );
		return tag;
	}

	@Override
	public Page<Tag> listar( Pageable dadosPaginacao, ListarTagFiltro filtro ) {
		return tagRepository.listar( dadosPaginacao );
	}

	@Override
	public Tag cadastrar( Tag tag ) {
		return tagRepository.cadastrar( tag );
	}

	@Override
	public Tag editar( Long id, Tag tag ) {
		tag.setId( id );
		return tagRepository.editar( tag );
	}

	@Override
	public void excluir( Long id ) {
		tagRepository.excluir( id );
	}
}
