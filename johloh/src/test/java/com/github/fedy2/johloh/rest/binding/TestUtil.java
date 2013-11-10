/**
 * 
 */
package com.github.fedy2.johloh.rest.binding;

import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.URL;

import com.github.fedy2.johloh.rest.http.HttpClient;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class TestUtil {
	
	public static void setGetReturn(HttpClient client, String resourceName, URL url) throws Exception
	{
		String getReturnValue = getResource(resourceName);
		when(client.get(url)).thenReturn(getReturnValue);
	}

	public static String getResource(String resourceName)
	{
		try {
			URL resourceUrl = Resources.getResource(resourceName);
			return Resources.toString(resourceUrl, Charsets.UTF_8);
		} catch(IOException e)
		{
			throw new RuntimeException("An error occurred loading the resource", e);
		}
	}

}
