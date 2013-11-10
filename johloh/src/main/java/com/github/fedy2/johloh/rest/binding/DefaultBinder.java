/**
 * 
 */
package com.github.fedy2.johloh.rest.binding;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.github.fedy2.johloh.rest.data.Response;

/**
 * The default resource binder.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
public class DefaultBinder implements Binder {

	protected JAXBContext context;
	protected Unmarshaller unmarshaller;
	protected Marshaller marshaller;

	/**
	 * Creates a new {@link DefaultBinder}.
	 */
	public DefaultBinder()
	{
		try {
			context = JAXBContext.newInstance(Response.class);
			unmarshaller = context.createUnmarshaller();
		} catch (Exception e) {
			throw new RuntimeException("Unmarshaller creation failed", e);
		}
	}

	/**
	 * Lazy creator of the {@link Marshaller}.
	 * @return the marshaller.
	 */
	protected Marshaller getMarshaller()
	{
		if (marshaller == null) {
			try {
				marshaller = context.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			} catch (Exception e) {
				throw new RuntimeException("Unmarshaller creation failed", e);
			}
		}
		return marshaller;
	}

	/** 
	 * {@inheritDoc} 
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T> Response<T> parse(String httpResponse) {
		try {
			return (Response<T>)unmarshaller.unmarshal(new StringReader(httpResponse));
		} catch(Exception e) {
			throw new RuntimeException("Parsing of response "+httpResponse+" failed.", e);
		}
	}

	/**
	 * Serializes the specified {@link Response} to a {@link String}.
	 * It is used for test purpose only.
	 * @param response the {@link Response} to serialize.
	 * @return the serialized response.
	 */
	public <T> String compose(Response<T> response) {
		try {
			StringWriter writer = new StringWriter();
			Marshaller marshaller = getMarshaller();
			marshaller.marshal(response, writer);
			return writer.toString();
		} catch(Exception e) {
			throw new RuntimeException("Composition of response "+response+" failed.", e);
		}
	}

}
