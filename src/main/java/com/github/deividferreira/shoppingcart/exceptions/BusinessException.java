package com.github.deividferreira.shoppingcart.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BusinessException extends ApplicationRuntimeException {

	public BusinessException(String message) {
		super(message);
	}
}
