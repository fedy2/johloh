/**
 * 
 */
package com.github.fedy2.johloh.query;

import com.github.fedy2.johloh.resource.Enlistment;

/**
 * Sort options for {@link Enlistment} type.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
public enum EnlistmentSort implements Sort<Enlistment> {

	MODULE_NAME("module_name"), 
	
	PROJECT("project"),
	
	TYPE("type"), 
	
	/**
	 *  (default)
	 */
	url("url");
	
	private String option;
	
	/**
	 * @param option
	 */
	private EnlistmentSort(String option) {
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
