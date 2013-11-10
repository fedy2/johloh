/**
 * 
 */
package com.github.fedy2.johloh.rest.http;

import java.net.URL;

/**
 * A generic HTTP client.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
public interface HttpClient {
	
	/**
	 * Retrieves the HTTP response from the specified {@link URL}.
	 * @param url the request {@link URL}.
	 * @return the retrieved response.
	 */
	public String get(URL url);

}
