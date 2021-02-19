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
package com.fiserv.api.ipp.documgmt.model;

import java.util.UUID;

/**
 * Error Type builder
 *
 * @author prateek.sharma
 */
public class ErrorTypeBuilder {
	private UUID	id;
	private String	code;
	private String	title;
	private String	detail;
	private String	sourcePointer;
	private String	sourceParameter;
	private String	sourceHeader;

	public ErrorTypeBuilder(UUID id) {
		this.id = id;
	}

	public ErrorTypeBuilder setId(UUID id) {
		this.id = id;
		return this;
	}

	public ErrorTypeBuilder setCode(@SuppressWarnings("SameParameterValue") String code) {
		this.code = code;
		return this;
	}

	public ErrorTypeBuilder setTitle(String title) {
		this.title = title;
		return this;
	}

	public ErrorTypeBuilder setDetail(String detail) {
		this.detail = detail;
		return this;
	}

	public ErrorTypeBuilder setSourcePointer(String sourcePointer) {
		this.sourcePointer = sourcePointer;
		return this;
	}

	public ErrorTypeBuilder setSourceParameter(String sourceParameter) {
		this.sourceParameter = sourceParameter;
		return this;
	}

	public ErrorTypeBuilder setSourceHeader(String sourceHeader) {
		this.sourceHeader = sourceHeader;
		return this;
	}

	public ErrorType build() {
		return new ErrorType(this);
	}

	protected UUID getId() {
		return id;
	}

	protected String getCode() {
		return code;
	}

	protected String getTitle() {
		return title;
	}

	protected String getDetail() {
		return detail;
	}

	protected String getSourcePointer() {
		return sourcePointer;
	}

	public String getSourceParameter() {
		return sourceParameter;
	}

	protected String getSourceHeader() {
		return sourceHeader;
	}
}
