package com.in28minutes.rest.website.restful_web_services.exception;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.in28minutes.rest.website.restful_web_services.user.UserNotFoundException;

@ControllerAdvice
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),
			ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	// 404 잘모된 응답 추가
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws
		Exception {
		ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),
			ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
		HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),
			"Total Errors : " + ex.getErrorCount() + " FirstError" +
				ex.getFieldError().getDefaultMessage(),
			request.getDescription(false));

		return new ResponseEntity<>(errorDetails.getErrorMessage(), HttpStatus.BAD_REQUEST);

	}

	// protected final ResponseEntity<ErrorDetails> handleMethodArgumentsNotValid(Exception ex, WebRequest request) throws
	// 	Exception {
	// 	ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), ex.getMessage(), request.getDescription(false));
	// 	return new ResponseEntity.toResponseEntity(errorDetails, HttpStatus.)
	//
	// }

}
