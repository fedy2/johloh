/**
 * 
 */
package com.github.fedy2.johloh.resource;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.github.fedy2.johloh.rest.binding.DateAdapter;

/**
 * An ActivityFact is a pre-computed collection of statistics about Project source code. It summarizes changes to lines of code, commits, and contributors in a single month.
 * SizeFacts contain the running totals of ActivityFacts.
 * An ActivityFact is derived from lower-level statistics contained in an Analysis. ActivityFacts are updated whenever a Project is re-analyzed.
 * ActivityFacts are availabled only after Ohloh has downloaded and analyzed the project source code.
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
@XmlRootElement(name="activity_fact")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActivityFact {
	
	@XmlElement
	@XmlJavaTypeAdapter(DateAdapter.class)
	protected Date month;
	
	@XmlElement(name="code_added")
	protected Integer codeAdded;
	
	@XmlElement(name="code_removed")
	protected Integer codeRemoved;
	
	@XmlElement(name="comments_added")
	protected Integer commentsAdded;
	
	@XmlElement(name="comments_removed")
	protected Integer commentsRemoved;
	
	@XmlElement(name="blanks_added")
	protected Integer blanksAdded;
	
	@XmlElement(name="blanks_removed")
	protected Integer blanksRemoved;
	
	@XmlElement
	protected Integer commits;
	
	@XmlElement
	protected Integer contributors;

	/**
	 * Indicates the month covered by this ActivityFact. 
	 * Only the year and month fields are significant. 
	 * This ActivityFact record includes all development activity that occured during this month.
	 */
	public Date getMonth() {
		return month;
	}

	/**
	 * The total new lines of code added, excluding comments and blanks, during this month.
	 */
	public Integer getCodeAdded() {
		return codeAdded;
	}

	/**
	 * The total lines of code removed, excluding comments and blanks, during this month.
	 */
	public Integer getCodeRemoved() {
		return codeRemoved;
	}

	/**
	 * The total lines of new comments added during this month.
	 */
	public Integer getCommentsAdded() {
		return commentsAdded;
	}

	/**
	 * The total lines of comments removed during this month.
	 */
	public Integer getCommentsRemoved() {
		return commentsRemoved;
	}

	/**
	 * The total blank lines added during this month.
	 */
	public Integer getBlanksAdded() {
		return blanksAdded;
	}

	/**
	 * The total blank lines removed during this month.
	 */
	public Integer getBlanksRemoved() {
		return blanksRemoved;
	}

	/**
	 * The number of commits made during this month.
	 */
	public Integer getCommits() {
		return commits;
	}

	/**
	 * The number of contributors who made at least one commit during this month.
	 */
	public Integer getContributors() {
		return contributors;
	}
}
