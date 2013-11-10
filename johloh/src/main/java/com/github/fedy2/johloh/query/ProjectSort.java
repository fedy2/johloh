/**
 * 
 */
package com.github.fedy2.johloh.query;

import com.github.fedy2.johloh.resource.Project;

/**
 * Sort options for {@link Project} resource.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
public enum ProjectSort implements Sort<Project> {
	
	NEW("new"),
	RATING("rating"),
	
	/**
	 * Highest active committers in past 12 months, first
	 */
	ACTIVE_COMMITTERS("active_committers"),
	ACTIVITY_LEVEL("activity_level"),
	
	/**
	 * Highest commits, first
	 */
	COMMIT_COUNT("commit_count"),
	
	/**
	 * Highest contributors, first
	 */
	COMMITTER_COUNT("committer_count"),
	STACK_COUNT("stack_count"),
	/**
	 * (default)
	 */
	STACK_COUNT_REVERSE("stack_count_reverse"),
	ID("id"),
	NAME("name"),
	/**
	 * Length of project name. Shorter name, first
	 */
	NAME_LENGTH("name_length"),
	UPDATED_AT("updated_at");
	
	private String option;
	
	/**
	 * @param option
	 */
	private ProjectSort(String option) {
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
