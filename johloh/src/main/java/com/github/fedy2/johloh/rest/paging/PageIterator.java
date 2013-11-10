/**
 * 
 */
package com.github.fedy2.johloh.rest.paging;

import java.util.Iterator;
import java.util.List;

import com.github.fedy2.johloh.rest.RequestUrl;
import com.github.fedy2.johloh.rest.RequestUrlBuilder;
import com.github.fedy2.johloh.rest.RestClient;
import com.github.fedy2.johloh.rest.data.Response;

/**
 * A result page iterator.
 * @author "Federico De Faveri defaveri@gmail.com"
 * @param <T> the page items type.
 */
public class PageIterator<T> implements Iterator<List<T>> {
	
	protected RequestUrlBuilder builder;
	protected RestClient restClient;
	protected int currentPage;
	protected int readItems;
	protected int totalItems;

	/**
	 * Creates a new {@link PageIterator}.
	 * @param builder the request URL builder.
	 * @param restClient the HTTP client.
	 */
	public PageIterator(RequestUrlBuilder builder, RestClient restClient) {
		this.builder = builder;
		this.restClient = restClient;
		this.currentPage = 0;
		this.readItems = 0;
		this.totalItems = 25;
	}

	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public boolean hasNext() {
		return readItems<totalItems;
	}

	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public List<T> next() {
		currentPage++;
		RequestUrl url = builder.parameter("page", currentPage).build();
		Response<T> response = restClient.request(url);
		if ("failed".equals(response.getStatus())) throw new RuntimeException("Request failed: "+response.getError());
		List<T> items = response.getResults();
		if (items.size() == 0) throw new RuntimeException("Received zero items");
		readItems += items.size();
		totalItems = response.getItemsAvailable();
		return items;
	}

	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public void remove() {}
}
