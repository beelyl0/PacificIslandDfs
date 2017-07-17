package com.pacificisland;

public class IllegalInputDataException extends Exception {

	public IllegalInputDataException() {
	}

	public IllegalInputDataException(String message) {
		super(message);
	}

	public IllegalInputDataException(Throwable cause) {
		super(cause);
	}

	public IllegalInputDataException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalInputDataException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
