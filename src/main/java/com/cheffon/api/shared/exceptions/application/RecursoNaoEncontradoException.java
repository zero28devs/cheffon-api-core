package com.cheffon.api.shared.exceptions.application;

public final class RecursoNaoEncontradoException extends Exception {

	public RecursoNaoEncontradoException( Class<?> recurso ) {
		super( "Recurso " + recurso.getSimpleName() + " não encontrado" );
	}
}
