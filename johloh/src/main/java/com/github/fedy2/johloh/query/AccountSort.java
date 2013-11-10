/**
 * 
 */
package com.github.fedy2.johloh.query;

import com.github.fedy2.johloh.resource.Account;

/**
 * Sort options for {@link Account} resource.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
public enum AccountSort implements Sort<Account> {
	
	/**
	 * (default)
	 */
	CREATED_AT("created_at"),
	NAME("name"),
	/**
	 * Recently updated, first
	 */
	UPDATED_AT("updated_at");
	
	private String option;
	
	/**
	 * @param option
	 */
	private AccountSort(String option) {
		this.option = option;
	}

	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public String getOption() {
		return option;
	}
}
