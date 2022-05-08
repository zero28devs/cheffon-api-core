package com.cheffon.api.domain.tags.services.filtros;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListarTagFiltroTest {
	@Test
	@DisplayName( "Quando getNome espero nome retornado" )
	void quandoGetNomeEsperoRetornoNome() {
		ListarTagFiltro filtro = new ListarTagFiltro();
		filtro.setNome( "Teste" );
		assertEquals("Teste", filtro.getNome());
	}

	@Test
	@DisplayName( "Quando setNome espero atribuição" )
	void quandoSetNomeEsperoAtribuicao() {
		ListarTagFiltro filtro = new ListarTagFiltro();
		filtro.setNome( "Tag teste" );
		assertEquals("Tag teste", filtro.getNome());
	}
}
