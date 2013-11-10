
package com.github.fedy2.johloh.resource;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.github.fedy2.johloh.rest.binding.DateAdapter;


/**
 * A SizeFact is a pre-computed collection of statistics about Project source code. 
 * It provides monthly running totals of lines of code, commits, and developer effort.
 * SizeFacts contain the running totals of ActivityFacts. 
 * A SizeFact is derived from lower-level statistics contained in an Analysis. 
 * SizeFacts are updated whenever a Project is re-analyzed.
 * SizeFacts are availabled only after Ohloh has downloaded and analyzed the project source code.
 * 
 */
@XmlRootElement(name="size_fact")
@XmlAccessorType(XmlAccessType.FIELD)
public class SizeFact {

    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
    protected Date month;
    
    @XmlElement
    protected Integer code;
    
    @XmlElement
    protected Integer comments;
    
    @XmlElement
    protected Integer blanks;
    
    @XmlElement(name = "comment_ratio")
    protected Double commentRatio;
    
    @XmlElement
    protected Integer commits;
    
    @XmlElement(name="man_months")
    protected Integer manMonths;
    
    /**
     * Indicates the month covered by this SizeFact. 
     * Only the year and month fields are significant. 
     * This SizeFact record includes all development activity that occured during this month.
     * 
     */
    public Date getMonth() {
        return month;
    }

    /**
     * The total net lines of code, excluding comments and blanks, as of the end of this month.
     * 
     */
    public Integer getCode() {
        return code;
    }

    /**
     * The total net lines of comments as of the end of this month.
     * 
     */
    public Integer getComments() {
        return comments;
    }

    /**
     * The total net blank lines as of the end of this month.
     * 
     */
    public Integer getBlanks() {
        return blanks;
    }

    /**
     * The fraction of net lines which are comments as of the end of this month.
     * 
     */
    public Double getCommentRatio() {
        return commentRatio;
    }

    /**
     * The cumulative total number commits to the project source control, including this month.
     * 
     */
    public Integer getCommits() {
        return commits;
    }

	/**
	 * The cumulative total months of effort expended by all contributors on this project, including this month. 
	 * For instance, if 1 contributor has worked for 3 months and 2 developers have each worked for 5 months, man_months will be 13. 
	 * This is the running total of the ActivityFact contributors property.
	 */
	public Integer getManMonths() {
		return manMonths;
	}
}
