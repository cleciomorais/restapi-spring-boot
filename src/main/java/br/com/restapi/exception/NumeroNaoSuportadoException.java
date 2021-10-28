package br.com.restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NumeroNaoSuportadoException extends RuntimeException {

	private static final long serialVersionUID = -859200856850454354L;

	public NumeroNaoSuportadoException(String exception) {
		super(exception);
	}
}
