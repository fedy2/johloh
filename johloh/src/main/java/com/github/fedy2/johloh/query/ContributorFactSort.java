/**
 * 
 */
package com.github.fedy2.johloh.query;

import com.github.fedy2.johloh.resource.ContributorFact;

/**
 * Sort options for {@link ContributorFact} resource.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
public enum ContributorFactSort implements Sort<ContributorFact> {
	
	NAME("name"), 
	
	KUDO_POSITION("kudo_position"),
	
	/**
	 * Highest commits, first
	 */
	COMMITS("commits"), 
	
	/**
	 *  (default) Highest commits in past twelve months, first
	 */
	COMMITS_12_MO("commits_12_mo"),
	
	LANGUAGE("language"),
	
	LATEST_COMMIT("latest_commit"),
	
	NEWEST("newest"),
	
	OLDEST("oldest");
	
	private String option;
	
	/**
	 * @param option
	 */
	private ContributorFactSort(String option) {
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
