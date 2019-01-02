package com.mindtree.Election.exceptions;

public class ElectionServiceException extends ElectionDaoException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ElectionServiceException() {
		super();
	}

	public ElectionServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ElectionServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ElectionServiceException(String message) {
		super(message);
	}

	public ElectionServiceException(Throwable cause) {
		super(cause);
	}

	
}
