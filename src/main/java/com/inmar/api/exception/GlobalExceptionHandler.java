package com.inmar.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = ShoppingCartException.class)
	public ResponseEntity<Object> invalidServerScore() {
		ErrorMessage errorMessage = new ErrorMessage("ERROR_SHOPPING_CART_01", "Invalid data Input");

		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = SKUDataException.class)
	public ResponseEntity<Object> invalidReceiverScore() {
		ErrorMessage errorMessage = new ErrorMessage("ERROR_SKUDATA_01", "Invalid data Input");
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}

}
