/**
 * 
 */
package com.github.fedy2.johloh.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A {@link RequestUrl} builder.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
public class RequestUrlBuilder {
	
	protected String scheme;
	protected String host;
	
	protected List<String> pathElements;
	protected Map<String, String> parameters;
	
	/**
	 * Creates a new {@link RequestUrlBuilder} with the specified service URL scheme and host with the specified default parameters.
	 * @param scheme the service URL scheme.
	 * @param host the service URL host.
	 * @param defaultParameters the default parameters.
	 */
	protected RequestUrlBuilder(String scheme, String host, Map<String, String> defaultParameters) {
		this.scheme = scheme;
		this.host = host;
		this.pathElements = new ArrayList<String>();
		this.parameters = new HashMap<String, String>(defaultParameters);
	}

	/**
	 * Adds the specified path elements to the {@link RequestUrl}.
	 * @param pathElements the path elements to add.
	 * @return the builder.
	 */
	public RequestUrlBuilder path(String ... pathElements) {
		for (String pathElement:pathElements) this.pathElements.add(pathElement);
		return this;
	}
	
	/**
	 * Adds the specified parameters to the {@link RequestUrl}.
	 * @param parameters the parameters to add.
	 * @return the builder.
	 */
	public RequestUrlBuilder parameters(Map<String, String> parameters) {
		this.parameters.putAll(parameters);;
		return this;
	}
	
	/**
	 * Adds the specified parameter to the {@link RequestUrl}.
	 * @param name the parameter name.
	 * @param value the parameter value.
	 * @return the builder.
	 */
	public RequestUrlBuilder parameter(String name, String value) {
		parameters.put(name, value);
		return this;
	}
	
	/**
	 * Adds the specified parameter to the {@link RequestUrl}.
	 * @param name the parameter name.
	 * @param value the parameter value.
	 * @return the builder.
	 */
	public RequestUrlBuilder parameter(String name, int value) {
		return parameter(name, String.valueOf(value));
	}
	
	/**
	 * Builds the {@link RequestUrl}.
	 * @return the {@link RequestUrl}.
	 */
	public RequestUrl build()
	{
		return new RequestUrl(scheme, host, pathElements, parameters);
	}
}
