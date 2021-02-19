package com.fiserv.api.ipp.documgmt.exception;

import com.fiserv.api.ipp.documgmt.model.ErrorType;
import org.apache.http.HttpStatus;

/**
 * Internal Server Error Exception
 *
 * @author prateek.sharma
 */
public class InternalServerErrorException extends APIException {

	private static final String CODE = "INTERNAL_SERVER_ERROR";
	private static final String TITLE = "The request failed due to an internal error.";

	public static ErrorType DEFAULT_INTERNAL_SERVER_ERROR = ErrorType.builder().setCode(CODE).setTitle(TITLE).build();

	public InternalServerErrorException(Throwable cause) {
		this(DEFAULT_INTERNAL_SERVER_ERROR, cause);
	}

	public InternalServerErrorException(String message) {
		this(ErrorType.builder().setCode(CODE).setTitle(message).build());
	}

	public InternalServerErrorException(String message, Throwable cause) {
		this(ErrorType.builder().setTitle(CODE).setTitle(message).build(), cause);
	}

	public InternalServerErrorException(ErrorType errorType) {
		this(errorType, null);
	}

	public InternalServerErrorException(ErrorType errorType, Throwable cause) {
		super(HttpStatus.SC_INTERNAL_SERVER_ERROR, errorType, cause);
	}
}
