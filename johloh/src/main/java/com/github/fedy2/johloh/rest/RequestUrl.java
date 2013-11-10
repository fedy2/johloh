/**
 * 
 */
package com.github.fedy2.johloh.rest;

import java.net.URI;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Represents a request url.
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class RequestUrl {

	public static String PATH_SEPARATOR = "/";
	public static String PARAMETER_SEPARATOR = "&";
	public static String PARAMETER_VALUE_SEPARATOR = "=";

	protected String scheme;
	protected String host;
	protected List<String> pathElements;
	protected Map<String, String> parameters;

	/**
	 * Creates a new {@link RequestUrl} with the specified parameters.
	 * @param scheme the service URL scheme.
	 * @param host the service URL host.
	 * @param pathElements the URL path elements.
	 * @param parameters the URL parameters.
	 */
	protected RequestUrl(String scheme, String host, List<String> pathElements,
			Map<String, String> parameters) {
		this.scheme = scheme;
		this.host = host;
		this.pathElements = Collections.unmodifiableList(pathElements);
		this.parameters = Collections.unmodifiableMap(parameters);
	}

	/**
	 * The URL scheme.
	 * @return the scheme
	 */
	public String getScheme() {
		return scheme;
	}

	/**
	 * The URL host.
	 * @return the host
	 */
	public String getHost() {
		return host;
	}
	
	/**
	 * The URL path elements.
	 * @return the pathElements
	 */
	public List<String> getPathElements() {
		return pathElements;
	}
	
	/**
	 * The URL parameters.
	 * @return the parameters
	 */
	public Map<String, String> getParameters() {
		return parameters;
	}

	/**
	 * Creates an {@link URL} starting from this {@link RequestUrl} elements.
	 * @return the produced {@link URL}.
	 */
	public URL toUrl()
	{
		try {
			String path = null;
			if (!pathElements.isEmpty()) {
				StringBuilder pathBuilder = new StringBuilder();
				Iterator<String> pathElementsIterator = pathElements.iterator();
				while(pathElementsIterator.hasNext()) {
					pathBuilder.append(PATH_SEPARATOR);
					pathBuilder.append(pathElementsIterator.next());
				}
				path = pathBuilder.toString();
			}

			String query = null;

			if (!parameters.isEmpty()) {
				StringBuilder queryBuilder = new StringBuilder();

				Iterator<Entry<String, String>> parametersIterator = parameters.entrySet().iterator();
				while(parametersIterator.hasNext()) {
					Entry<String, String> parameter = parametersIterator.next();
					queryBuilder.append(parameter.getKey());
					queryBuilder.append(PARAMETER_VALUE_SEPARATOR);
					queryBuilder.append(parameter.getValue());

					if (parametersIterator.hasNext()) queryBuilder.append(PARAMETER_SEPARATOR);
				}
				query = queryBuilder.toString();
			}

			URI uri = new URI(scheme, host, path, query, null);

			return uri.toURL();
		} catch (Exception e)
		{
			throw new RuntimeException("Url generation failed", e);
		}
	}
}
