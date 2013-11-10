/**
 * 
 */
package com.github.fedy2.johloh.query;

import com.github.fedy2.johloh.resource.Stack;

/**
 * Sort options for {@link Stack} resource.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
public enum StackSort implements Sort<Stack> {
	
	ID("id"),
	
	/**
	 * (default)
	 */
	NAME("name"),
	
	/**
	 * Time at which the Project was added to the stack
	 */
	CREATED_AT("created_at"),
	PROJECT_COUNT("project_count");
	
	private String option;
	
	/**
	 * @param option
	 */
	private StackSort(String option) {
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
