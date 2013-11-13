/**
 * 
 */
package com.github.fedy2.johloh.query;

import java.util.ArrayList;
import java.util.List;

/**
 * A generic {@link Query} builder.
 * @author "Federico De Faveri defaveri@gmail.com"

 * @param <T> the resource type.
 * @param <S> the {@link Sort} type.
 * @param <THIS> this.
 */
@SuppressWarnings("unchecked")
public class QueryBuilder<T, S extends Enum<S> & Sort<T>, THIS extends QueryBuilder<T, S, THIS>> {
	
	protected String query;
	protected List<S> sortOptions = new ArrayList<S>();
	
	/**
	 * Specify the query parameter.
	 * @param query the query parameter.
	 * @return the builder.
	 */
	public THIS query(String query) {
		this.query = query;
		return (THIS) this;
	}
	
	/**
	 * Specify one or more {@link Sort} options.
	 * @param sortOptions the sort options.
	 * @return the builder.
	 */
	public THIS sort(S ... sortOptions) {
		for (S sortOption:sortOptions) this.sortOptions.add(sortOption);
		return (THIS) this;
	}
	
	/**
	 * Builds the {@link Query}.
	 * @return the created query.
	 */
	public Query<T> build()
	{
		return new Query<T>(query, (List<Sort<T>>) sortOptions);
	}
}
