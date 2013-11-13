/**
 * 
 */
package com.github.fedy2.johloh.rest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class RequestUrlBuilderTest {
	
	protected static String SCHEMA = "https";
	protected static String HOST = "www.ohloh.net";
	protected static List<String> ZERO_PATH_ELEMENTS = Collections.<String>emptyList();
	protected static Map<String,String> ZERO_PARAMETERS = Collections.<String,String>emptyMap();
	
	@Test
	public void testEmpty() throws MalformedURLException {
		RequestUrl urlRequest = new RequestUrl(SCHEMA, HOST, ZERO_PATH_ELEMENTS, ZERO_PARAMETERS);
		URL url = urlRequest.toUrl();
		
		assertNotNull(url);
		
		String expectedUrl = SCHEMA+"://"+HOST;
		assertEquals(expectedUrl, url.toString());
	}

	@Test
	public void withPathElements() throws MalformedURLException {
		
		String pathElement1 = "projects";
		String pathElement2 = "12345.xml";
		List<String> pathElements = Arrays.asList(pathElement1, pathElement2);
		
		RequestUrl urlRequest = new RequestUrl(SCHEMA, HOST, pathElements, ZERO_PARAMETERS);
		URL url = urlRequest.toUrl();
		
		assertNotNull(url);
		
		String expectedUrl = SCHEMA+"://"+HOST+"/"+pathElement1+"/"+pathElement2;
		assertEquals(expectedUrl, url.toString());
		
	}
	
	@Test
	public void withParameters() throws MalformedURLException {
		
		String parameter1Name = "query";
		String parameter1Value = "myTestQuery";
		String parameter2Name = "page";
		String parameter2Value = "1";
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(parameter1Name, parameter1Value);
		parameters.put(parameter2Name, parameter2Value);
		
		RequestUrl urlRequest = new RequestUrl(SCHEMA, HOST, ZERO_PATH_ELEMENTS, parameters);
		URL url = urlRequest.toUrl();
		
		assertNotNull(url);
		
		String expectedUrl = SCHEMA+"://"+HOST+"?"+parameter2Name+"="+parameter2Value+"&"+parameter1Name+"="+parameter1Value;
		assertEquals(expectedUrl, url.toString());
		
	}
	
	@Test
	public void withPathElementsAndParameters() throws MalformedURLException {
		
		String pathElement1 = "projects";
		String pathElement2 = "12345.xml";
		List<String> pathElements = Arrays.asList(pathElement1, pathElement2);
		
		String parameter1Name = "query";
		String parameter1Value = "myTestQuery";
		String parameter2Name = "page";
		String parameter2Value = "1";
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(parameter1Name, parameter1Value);
		parameters.put(parameter2Name, parameter2Value);
		
		RequestUrl urlRequest = new RequestUrl(SCHEMA, HOST, pathElements, parameters);
		URL url = urlRequest.toUrl();
		
		assertNotNull(url);
		
		String expectedUrl = SCHEMA+"://"+HOST+"/"+pathElement1+"/"+pathElement2+"?"+parameter2Name+"="+parameter2Value+"&"+parameter1Name+"="+parameter1Value;
		assertEquals(expectedUrl, url.toString());
	}
	
	@Test
	public void pathElementsWithInvalidCharacters() throws MalformedURLException {
		
		String pathElement1 = "my projects";
		String pathElement2 = "12345.xml";
		List<String> pathElements = Arrays.asList(pathElement1, pathElement2);
		
		RequestUrl urlRequest = new RequestUrl(SCHEMA, HOST, pathElements, ZERO_PARAMETERS);
		URL url = urlRequest.toUrl();
		
		assertNotNull(url);
		
		String expectedUrl = SCHEMA+"://"+HOST+"/"+"my%20projects"+"/"+pathElement2;
		assertEquals(expectedUrl, url.toString());
	}
	
	@Test
	public void parametersWithInvalidCharacters() throws MalformedURLException {
		
		String parameter1Name = "query";
		String parameter1Value = "my TestQuery";
		String parameter2Name = "page";
		String parameter2Value = "1";
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(parameter1Name, parameter1Value);
		parameters.put(parameter2Name, parameter2Value);
		
		RequestUrl urlRequest = new RequestUrl(SCHEMA, HOST, ZERO_PATH_ELEMENTS, parameters);
		URL url = urlRequest.toUrl();
		
		assertNotNull(url);
		
		String expectedUrl = SCHEMA+"://"+HOST+"?"+parameter2Name+"="+parameter2Value+"&"+parameter1Name+"="+"my%20TestQuery";
		assertEquals(expectedUrl, url.toString());
	}
	

}
