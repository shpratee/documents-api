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
 * Forbidden Exception
 *
 * @author prateek.sharma
 */
public class ForbiddenException extends APIException {

	private static final String CODE = "FORBIDDEN";

	public ForbiddenException(String message) {
		this(ErrorType.builder().setCode(CODE).setTitle(message).build());
	}

	public ForbiddenException(String message, Throwable e) {
		this(ErrorType.builder().setTitle(CODE).setTitle(message).build(), e);
	}

	public ForbiddenException(ErrorType errorType) {
		this(errorType, null);
	}

	public ForbiddenException(ErrorType errorType, Throwable cause) {
		super(HttpStatus.SC_FORBIDDEN, errorType, cause);
	}
}
