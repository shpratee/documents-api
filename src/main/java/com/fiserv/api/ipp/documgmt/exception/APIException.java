/*
 * Copyright 2020 BASE Logic, Inc
 * https://baselogic.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fiserv.api.ipp.documgmt.exception;

import com.fiserv.api.ipp.documgmt.model.ErrorType;
import org.apache.http.HttpStatus;

/**
 * API Exception
 *
 * @author prateek.sharma
 */
public class APIException extends RuntimeException {
	private final ErrorType errorType;
	private final int httpStatus;

	protected APIException(int httpStatus, ErrorType errorType) {
		this(httpStatus, errorType, null);
	}

	protected APIException(int httpStatus, ErrorType errorType, Throwable cause) {
		super(errorType.getTitle(), cause);
		this.httpStatus = httpStatus;
		this.errorType = errorType;
	}

	public ErrorType getErrorType() {
		return errorType;
	}

	public int getHttpStatus() {
		return httpStatus;
	}
}
