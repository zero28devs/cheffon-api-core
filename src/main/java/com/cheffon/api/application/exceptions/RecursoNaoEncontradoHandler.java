package com.cheffon.api.application.exceptions;

import com.cheffon.api.shared.exceptions.responses.ErroResponse;
import com.cheffon.api.shared.exceptions.application.RecursoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public final class RecursoNaoEncontradoHandler {
	@ResponseStatus( HttpStatus.NOT_FOUND)
	@ExceptionHandler( RecursoNaoEncontradoException.class)
	public ErroResponse handle(RecursoNaoEncontradoException exception) {
		return new ErroResponse( "Recurso não encontrado", exception.getLocalizedMessage() );
	}
}
