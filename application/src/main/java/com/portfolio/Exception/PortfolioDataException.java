package com.portfolio.Exception;

public class PortfolioDataException extends Exception {

	private static final long serialVersionUID = 1L;

	public PortfolioDataException(String errorCode, String message, Throwable e) {
		super(errorCode + " | " + message, e);
	}
}
