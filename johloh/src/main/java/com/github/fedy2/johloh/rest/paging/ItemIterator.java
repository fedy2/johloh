/**
 * 
 */
package com.github.fedy2.johloh.rest.paging;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Single page items iterator.
 * @author "Federico De Faveri defaveri@gmail.com"
 * @param <E> the item type.
 */
public class ItemIterator<E> implements Iterator<E> {
	
	protected PageIterator<E> pageIterator;
	protected Iterator<E> currentIterator;

	/**
	 * Creates an {@link ItemIterator}.
	 * @param pageIterator the page iterator.
	 */
	public ItemIterator(PageIterator<E> pageIterator) {
		this.pageIterator = pageIterator;
		this.currentIterator = Collections.<E>emptyList().iterator();
	}

	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public boolean hasNext() {
		return currentIterator.hasNext() || pageIterator.hasNext();
	}

	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public E next() {
		if (!currentIterator.hasNext()) loadNextPage();
		return currentIterator.next();
	}
	
	/**
	 * Loads the next items page.
	 */
	protected void loadNextPage()
	{
		if (!pageIterator.hasNext()) throw new IllegalStateException("There are no more pages");
		List<E> page = pageIterator.next();
		currentIterator = page.iterator();
	}

	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public void remove() {}

}
