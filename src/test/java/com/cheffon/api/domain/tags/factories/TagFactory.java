package com.cheffon.api.domain.tags.factories;

import com.cheffon.api.domain.tags.entities.Tag;

public final class TagFactory {

	public Tag gerarPadrao() {
		return new Tag( "teste" );
	}
}
