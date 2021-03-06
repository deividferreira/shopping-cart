package com.github.deividferreira.shoppingcart.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ApplicationRuntimeException extends RuntimeException {
	
	public ApplicationRuntimeException(String message) {
		super(message);
	}
}
