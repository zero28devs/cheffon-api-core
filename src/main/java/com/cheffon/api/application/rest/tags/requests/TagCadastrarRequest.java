package com.cheffon.api.application.rest.tags.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TagCadastrarRequest {

	@NotNull
	@NotEmpty
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome( String nome ) {
		this.nome = nome;
	}
}
