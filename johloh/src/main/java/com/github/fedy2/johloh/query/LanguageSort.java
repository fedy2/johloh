/**
 * 
 */
package com.github.fedy2.johloh.query;

import com.github.fedy2.johloh.resource.Language;

/**
 * Sort options for {@link Language} resource.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
public enum LanguageSort implements Sort<Language> {
	
	/**
	 * Results are sort by the total source lines, including comments and blanks, from highest to lowest.
	 */
	TOTAL("total"), 
	
	/**
	 * Results are sorted by code lines only from highest to lowest.
	 */
	CODE("code"),
	
	/**
	 * Results are sorted by the number of projects, from highest to lowest.
	 */
	PROJECTS("projects"),
	
	/**
	 * Results are sorted by comment_ratio from highest to lowest. Results are sorted by the number of Projects, from highest to lowest.
	 */
	COMMENT_RATIO("comment_ratio"),
	
	/**
	 * Results are sorted by the number of contributors, from highest to lowest
	 */
	CONTRIBUTORS("contributors"),
	
	/**
	 * Results are sorted by the number of commits, from highest to lowest.
	 */
	COMMITS("commits"),
	
	/**
	 * (default) Results are sorted alphabetically by nice_name.
	 */
	NAME("name");
	
	private String option;
	
	/**
	 * @param option
	 */
	private LanguageSort(String option) {
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
