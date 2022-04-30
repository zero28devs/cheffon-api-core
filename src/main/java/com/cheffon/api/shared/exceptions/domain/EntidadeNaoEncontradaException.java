package com.cheffon.api.shared.exceptions.domain;

public class EntidadeNaoEncontradaException extends Exception {

	public EntidadeNaoEncontradaException(Class<?> entidade) {
		super("Entidade " + entidade.getSimpleName() + " não encontrada");
	}
}
