/**
 * 
 */
package com.github.fedy2.johloh.query;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.github.fedy2.johloh.rest.RequestUrl;

/**
 * A query.
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 * @param <T> the resource type.
 */
public class Query<T> {
	
	protected static Query<Object> EMPTY_QUERY = new Query<Object>(null, Collections.<Sort<Object>>emptyList());
	
	/**
	 * Returns an empty {@link Query}.
	 * @return the empty query.
	 */
	@SuppressWarnings("unchecked")
	public static <T> Query<T> emptyQuery() {
		return (Query<T>) EMPTY_QUERY;
	}
	
	protected String query;
	protected List<Sort<T>> sortOptions;

	/**
	 * Creates a new {@link Query}.
	 * @param query the query parameter.
	 * @param sortOptions the sort options.
	 */
	protected Query(String query, List<Sort<T>> sortOptions) {
		this.query = query;
		this.sortOptions = sortOptions;
	}
	
	/**
	 * The query parameter.
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}
	
	/**
	 * The sort options.
	 * @return the sortOptions
	 */
	public List<Sort<T>> getSortOptions() {
		return sortOptions;
	}
	
	/**
	 * Returns the {@link RequestUrl} parameters generated from this query.
	 * @return the parameters.
	 */
	public Map<String, String> toParameters()
	{
		Map<String, String> parameters = new HashMap<String, String>();
	
		if (query!=null) parameters.put("query", query);
		
		if (sortOptions != null && !sortOptions.isEmpty()) {
			StringBuilder sort = new StringBuilder();
			Iterator<Sort<T>> sortOptionsIterator = sortOptions.iterator();
			while(sortOptionsIterator.hasNext()) {
				sort.append(sortOptionsIterator.next().getOption());
				if (sortOptionsIterator.hasNext()) sort.append(",");
			}
			parameters.put("sort", sort.toString());
		}
		
		return parameters;
	}
	
	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Query [query=");
		builder.append(query);
		builder.append(", sortOptions=");
		builder.append(sortOptions);
		builder.append("]");
		return builder.toString();
	}	
}
