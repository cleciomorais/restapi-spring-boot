package br.com.restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NumeroDivisaoPorZeroException extends RuntimeException {

	private static final long serialVersionUID = -3493995862922364296L;

	public NumeroDivisaoPorZeroException(String exception) {
		super(exception);
	}
}
