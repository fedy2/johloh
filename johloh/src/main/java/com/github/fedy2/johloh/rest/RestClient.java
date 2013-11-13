/**
 * 
 */
package com.github.fedy2.johloh.rest;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.github.fedy2.johloh.rest.binding.Binder;
import com.github.fedy2.johloh.rest.binding.DefaultBinder;
import com.github.fedy2.johloh.rest.data.Response;
import com.github.fedy2.johloh.rest.http.DefaultHttpClient;
import com.github.fedy2.johloh.rest.http.HttpClient;

/**
 * The service REST client.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
public class RestClient {
	
	protected String scheme;
	protected String host;
	
	protected HttpClient httpClient;
	protected Binder binder;
	
	protected Map<String, String> defaultParameters = new HashMap<String, String>();
	
	/**
	 * Creates a new {@link RestClient} with the specified service URL scheme and host.
	 * @param scheme the service URL scheme
	 * @param host the service URL host.
	 */
	public RestClient(String scheme, String host) {
		this(scheme, host, new DefaultHttpClient(), new DefaultBinder());
	}
	
	/**
	 * Creates a new {@link RestClient} with the specified service URL scheme and host.
	 * The specified {@link HttpClient} will be used for the HTTP requests.
	 * @param scheme the service URL scheme
	 * @param host the service URL host.
	 * @param httpClient the {@link HttpClient} to use.
	 */
	public RestClient(String scheme, String host, HttpClient httpClient) {
		this(scheme, host, httpClient, new DefaultBinder());
	}
	
	/**
	 * Creates a new {@link RestClient} with the specified service URL scheme and host.
	 * The specified {@link HttpClient} will be used for the HTTP requests.
	 * The specified {@link Binder} will be used to deserialize service {@link Response}s.
	 * @param scheme the service URL scheme
	 * @param host the service URL host.
	 * @param httpClient the {@link HttpClient} to use.
	 * @param responseParser the response parser to use.
	 */
	public RestClient(String scheme, String host, HttpClient httpClient,
			Binder responseParser) {
		this.scheme = scheme;
		this.host = host;
		this.httpClient = httpClient;
		this.binder = responseParser;
	}
	
	/**
	 * Adds a default parameter that will be appended to all the requests.
	 * @param name the parameter name.
	 * @param value the parameter value.
	 */
	public void addDefaultParameter(String name, String value)
	{
		defaultParameters.put(name, value);
	}

	/**
	 * Creates a {@link RequestUrlBuilder}.
	 * @return the request builder.
	 */
	public RequestUrlBuilder getRequestUrlBuilder()
	{
		return new RequestUrlBuilder(scheme, host, defaultParameters);
	}
	
	/**
	 * Makes a REST request to the specified {@link RequestUrl}.
	 * @param requestUrl the request URL.
	 * @return the service {@link Response}.
	 */
	public <T> Response<T> request(RequestUrl requestUrl) {
		assert requestUrl!=null;
		
		URL url = requestUrl.toUrl();
		return request(url);
	}
	
	/**
	 * Makes a REST request to the specified {@link URL}.
	 * @param url the request {@link URL}.
	 * @return the service {@link Response}.
	 */
	public <T> Response<T> request(URL url) {
		assert url!=null;

		String httpResponse = httpClient.get(url);
		Response<T> response = binder.parse(httpResponse);
		return response;
	}
}
