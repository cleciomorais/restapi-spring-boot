package br.com.restapi.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.restapi.exception.ExceptionResponseApi;
import br.com.restapi.exception.NumeroDivisaoPorZeroException;
import br.com.restapi.exception.NumeroNaoSuportadoException;
import br.com.restapi.exception.RegistroNaoEncontradoException;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponseApi> handleAllExceptions(Exception ex, WebRequest request){
		ExceptionResponseApi exception = new ExceptionResponseApi(new Date(), ex.getMessage(), request.getDescription(Boolean.FALSE), HttpStatus.INTERNAL_SERVER_ERROR.toString());
		
		return new ResponseEntity<ExceptionResponseApi>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NumeroNaoSuportadoException.class)
	public final ResponseEntity<ExceptionResponseApi> handleBadRequestExceptions(Exception ex, WebRequest request){
		ExceptionResponseApi exception = new ExceptionResponseApi(new Date(), ex.getMessage(), request.getDescription(Boolean.FALSE), HttpStatus.BAD_REQUEST.toString());
		
		return new ResponseEntity<ExceptionResponseApi>(exception, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RegistroNaoEncontradoException.class)
	public final ResponseEntity<ExceptionResponseApi> handleRegistroNaoEncontradoException(Exception ex, WebRequest request){
		ExceptionResponseApi exception = new ExceptionResponseApi(new Date(), ex.getMessage(), request.getDescription(Boolean.FALSE), HttpStatus.NOT_FOUND.value() +"");
		
		return new ResponseEntity<ExceptionResponseApi>(exception, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public final ResponseEntity<ExceptionResponseApi> handleNumberFormatExceptions(Exception ex, WebRequest request){
		ExceptionResponseApi exception = new ExceptionResponseApi(new Date(), ex.getMessage(), request.getDescription(Boolean.FALSE), HttpStatus.BAD_REQUEST.toString());
		
		return new ResponseEntity<ExceptionResponseApi>(exception, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NumeroDivisaoPorZeroException.class)
	public final ResponseEntity<ExceptionResponseApi> handleNumeroDivisaoPorZeroException(Exception ex, WebRequest request){
		ExceptionResponseApi exception = new ExceptionResponseApi(new Date(), ex.getMessage(), request.getDescription(Boolean.FALSE), HttpStatus.BAD_REQUEST.toString());
		
		return new ResponseEntity<ExceptionResponseApi>(exception, HttpStatus.BAD_REQUEST);
	}
}
