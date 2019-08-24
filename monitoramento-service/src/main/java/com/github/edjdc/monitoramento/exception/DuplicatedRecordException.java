package com.github.edjdc.monitoramento.exception;

public class DuplicatedRecordException extends RuntimeException {

	private static final long serialVersionUID = 8248299523085267312L;

	public DuplicatedRecordException() {
		super();
	}

	public DuplicatedRecordException(String message) {
		super(message);
	}

}
