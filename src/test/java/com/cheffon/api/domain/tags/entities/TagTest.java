package com.cheffon.api.domain.tags.entities;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TagTest {

	@Test
	@DisplayName( "Quando construtor criado espero atribuição" )
	void quandoConstrutorCriadoEsperoAtribuicao() {
		Tag tag = new Tag( "teste" );
		assertEquals( "teste", tag.getNome() );
	}

	@Test
	@DisplayName( "Quando setId espero atribuição" )
	void quandoSetIdEsperoAtribuicao() {
		Tag tag = new Tag( "teste" );
		tag.setId( 1L );
		assertEquals( 1L, tag.getId() );
	}

	@Test
	@DisplayName( "Quando equals valido espero sucesso" )
	void quandoEqualsValidoEsperoSucesso() {
		EqualsVerifier.simple().forClass( Tag.class ).verify();
	}

	@Test
	@DisplayName( "Quando toString espero valor válido" )
	void quandoToStringEsperoValorValido() {
		Tag tag = new Tag( "teste" );
		assertEquals( "Tag{id=null, nome='teste'}", tag.toString() );
	}
}
