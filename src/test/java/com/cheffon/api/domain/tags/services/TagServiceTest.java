package com.cheffon.api.domain.tags.services;

import com.cheffon.api.domain.rating.entities.Tag;
import com.cheffon.api.domain.tags.factories.TagFactory;
import com.cheffon.api.domain.tags.repositories.TagRepository;
import com.cheffon.api.infra.repositories.tags.TagDatabaseRepository;
import com.cheffon.api.shared.exceptions.domain.EntidadeNaoEncontradaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TagServiceTest {

	private TagRepository<Page<Tag>, Pageable> tagRepository;
	private TagService<Page<Tag>, Pageable> tagService;
	private TagFactory tagFactory;

	@BeforeEach
	void setup() {
		tagRepository = mock( TagDatabaseRepository.class );
		tagService = new TagService<>( tagRepository );
		tagFactory = new TagFactory();
	}

	@Test
	@DisplayName( "Quando validar com código válido espero Tag válida" )
	void quandoValidarComCodigoValidoEsperoTagValida() throws EntidadeNaoEncontradaException {
		Tag tag = tagFactory.gerarPadrao();
		when( tagRepository.buscar( 1L ) ).thenReturn( tag );
		Tag tagRetornada = tagService.validar( 1L );
		assertEquals( tag, tagRetornada );
	}

	@Test
	@DisplayName( "Quando validar com código não existente espero EntidadeNaoEncontradaException" )
	void quandoValidarComCodigoInvalidoEsperoEntidadeNaoEncontrada() {
		Tag tag = tagFactory.gerarPadrao();
		when( tagRepository.buscar( 999L ) ).thenReturn( null );
		assertThrowsExactly( EntidadeNaoEncontradaException.class, () -> tagService.validar( 999L ) );
	}
}
