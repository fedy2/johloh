/**
 * 
 */
package com.github.fedy2.johloh.rest.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

/**
 * A default {@link HttpClient} implementation that uses JDK standard classes.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
public class DefaultHttpClient implements HttpClient {

	protected static final int DEFAULT_BUFFER_SIZE = 1024 * 4;

	protected int bufferSize;
	protected Proxy proxy;

	/**
	 * Creates a new {@link DefaultHttpClient} with no proxies.
	 */
	public DefaultHttpClient() {
		this(Proxy.NO_PROXY);
	}

	/**
	 * Creates a new {@link DefaultHttpClient} with the specified {@link Proxy}.
	 * @param proxy the {@link Proxy} to use for the HTTP connections.
	 */
	public DefaultHttpClient(Proxy proxy) {
		this(DEFAULT_BUFFER_SIZE, proxy);
	}

	/**
	 * Creates a new {@link DefaultHttpClient} with the specified {@link Proxy} and buffer size;
	 * @param bufferSize the buffer size.
	 * @param proxy the {@link Proxy} to use for the HTTP connections.
	 */
	public DefaultHttpClient(int bufferSize, Proxy proxy) {
		this.bufferSize = bufferSize;
		this.proxy = proxy;
		HttpURLConnection.setFollowRedirects(true);
	}

	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public String get(URL url) {
		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);

			int status = connection.getResponseCode();

			if (status != HttpURLConnection.HTTP_OK) {
				if (status == HttpURLConnection.HTTP_MOVED_TEMP
						|| status == HttpURLConnection.HTTP_MOVED_PERM
						|| status == HttpURLConnection.HTTP_SEE_OTHER) {


					String newUrl = connection.getHeaderField("Location");
					connection = (HttpURLConnection) new URL(newUrl).openConnection();
				} else throw new RuntimeException("Http connection failed with status code "+status);
			}

			InputStream is = connection.getInputStream();
			InputStreamReader reader = new InputStreamReader(is);
			StringWriter writer = new StringWriter();
			copy(reader, writer);
			reader.close();
			is.close();

			return writer.toString();
		} catch (Exception e) {
			throw new RuntimeException("GET request failed for url "+url, e);
		}
	}

	/**
	 * Copy the input reader into the output writer.
	 * @param input the input reader.
	 * @param output the output writer.
	 * @return the number of char copied.
	 * @throws IOException if an error occurs during the copy.
	 */
	protected long copy(Reader input, Writer output) throws IOException {
		char[] buffer = new char[bufferSize];
		long count = 0;
		int n = 0;
		while (-1 != (n = input.read(buffer))) {
			output.write(buffer, 0, n);
			count += n;
		}
		return count;
	}
}
