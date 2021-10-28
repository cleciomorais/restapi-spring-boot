package br.com.restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RegistroNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = -859200856850454354L;

	public RegistroNaoEncontradoException(String exception) {
		super(exception);
	}
}
