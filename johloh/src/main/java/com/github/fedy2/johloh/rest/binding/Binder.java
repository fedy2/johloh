/**
 * 
 */
package com.github.fedy2.johloh.rest.binding;

import com.github.fedy2.johloh.rest.data.Response;

/**
 * Deserialize the service response.
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public interface Binder {
	
	/**
	 * Deserializes the specified {@link String} into a {@link Response}.
	 * @param httpResponse the string to deserialize.
	 * @return the deserialized string.
	 */
	public <T> Response<T> parse(String httpResponse);

}
