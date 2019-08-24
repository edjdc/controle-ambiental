package com.github.edjdc.seguranca.exception;

public class RecordNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8248299523085267312L;

	public RecordNotFoundException() {
		super();
	}

	public RecordNotFoundException(String message) {
		super(message);
	}

}
