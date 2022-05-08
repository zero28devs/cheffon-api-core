package com.cheffon.api.infra.repositories.tags;

import com.cheffon.api.application.mapings.tags.TagMapper;
import com.cheffon.api.domain.tags.entities.Tag;
import com.cheffon.api.domain.tags.repositories.TagRepository;
import com.cheffon.api.domain.tags.services.filtros.ListarTagFiltro;
import com.cheffon.api.infra.db.jpa.tags.TagDataRepository;
import com.cheffon.api.infra.db.orm.tags.TagData;
import com.cheffon.api.infra.db.orm.tags.TagDataSpecification;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TagDatabaseRepository implements TagRepository<Page<Tag>, Pageable> {

	private final TagDataRepository tagDataRepository;

	@Autowired
	public TagDatabaseRepository( TagDataRepository tagDataRepository ) {
		this.tagDataRepository = tagDataRepository;
	}

	@Override
	public Tag buscar( Long id ) {
		TagData tagData = tagDataRepository.findById( id ).orElse( null );
		return TagMapper.INSTANCE.tagDataToTag( tagData );
	}

	@Override
	public Page<Tag> listar( Pageable dadosPaginacao, ListarTagFiltro filtro ) {
		TagDataSpecification tagDataSpecification = new TagDataSpecification( filtro );
		Page<TagData> tagsDatasPagina = tagDataRepository.findAll( tagDataSpecification, dadosPaginacao );
		List<Tag> tags = tagsDatasPagina.getContent().stream().map( TagMapper.INSTANCE::tagDataToTag ).toList();
		return new PageImpl<>( tags, dadosPaginacao, tagsDatasPagina.getTotalElements() );
	}

	@Override
	public Tag cadastrar( Tag tag ) {
		return persistirTag( tag );
	}

	@Override
	public Tag editar( Tag tag ) {
		return persistirTag( tag );
	}

	@Override
	public void excluir( Long codigo ) {
		tagDataRepository.deleteById( codigo );
	}

	private Tag persistirTag( Tag tag ) {
		TagData tagData = TagMapper.INSTANCE.tagToTagData( tag );
		TagData tagDataSalva = tagDataRepository.save( tagData );
		return TagMapper.INSTANCE.tagDataToTag( tagDataSalva );
	}
}
