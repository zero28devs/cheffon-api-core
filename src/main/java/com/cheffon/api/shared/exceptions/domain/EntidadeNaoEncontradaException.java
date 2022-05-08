package com.cheffon.api.shared.exceptions.domain;

public final class EntidadeNaoEncontradaException extends Exception {

	public EntidadeNaoEncontradaException( Class<?> entidade ) {
		super( "Entidade " + entidade.getSimpleName() + " não encontrada" );
	}
}
