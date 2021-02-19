package com.fiserv.api.ipp.documgmt.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

import io.vertx.core.http.HttpServerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Filter to log request and response elements
 *
 * @author prateek.sharma
 */
@Provider
@Priority(value = 10)
public class RequestResponseLoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

	@Context
	UriInfo info;

	@Context
	HttpServerRequest request;

	private static Logger logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class.getName());

	@Override
	public void filter(ContainerRequestContext context) throws IOException {
		final String method = context.getMethod();
		final String path = info.getPath();
		final String address = request.remoteAddress().toString();

//		InputStream is = context.getEntityStream();
//
//		String payload = null;
//		try (Reader reader = new InputStreamReader(is)) {
//			payload = CharStreams.toString(reader);
//		}

		logger.info(String.format("Request received method -> %s, path -> %s,  headers -> %s from IP %s", method, path, context.getHeaders(), address));
	}

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		final String method = requestContext.getMethod();
		final String path = info.getPath();

		logger.info(String.format("Response sent method -> %s, path -> %s, status -> %s, headers -> %s", method, path, responseContext.getStatus(), responseContext.getStringHeaders()));
	}
}
