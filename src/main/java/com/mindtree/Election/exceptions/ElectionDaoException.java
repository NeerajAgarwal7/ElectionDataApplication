package com.mindtree.Election.exceptions;

public class ElectionDaoException extends AppException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ElectionDaoException() {
		super();
	}

	public ElectionDaoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ElectionDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ElectionDaoException(String message) {
		super(message);
	}

	public ElectionDaoException(Throwable cause) {
		super(cause);
	}

}
