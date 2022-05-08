package com.cheffon.api.shared.exceptions.domain;

public final class AtributoInvalidoException extends Exception {

	public AtributoInvalidoException( String atributo ) {
		super( "Atributo " + atributo + " inválido" );
	}
}
