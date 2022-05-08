package com.cheffon.api.application.services.tags.interfaces;

import com.cheffon.api.domain.tags.entities.Tag;
import com.cheffon.api.domain.tags.services.filtros.ListarTagFiltro;
import com.cheffon.api.shared.exceptions.application.RecursoNaoEncontradoException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TagApplicationService {

	Tag buscar( Long id ) throws RecursoNaoEncontradoException;

	Page<Tag> listar( Pageable dadosPaginacao, ListarTagFiltro filtro );

	Tag cadastrar( Tag tag );

	Tag editar( Long id, Tag tag );

	void excluir( Long id );
}
