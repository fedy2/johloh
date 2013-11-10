
package com.github.fedy2.johloh.resource;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.github.fedy2.johloh.rest.binding.DateAdapter;


/**
 * A ContributorFact contains a selection of high-level statistics about a person who commited source code to a Project. 
 * One ContributorFact record exists for each contributor. A ContributorFact is part of an Analysis, and is derived 
 * from lower-level statistics contained within the Analysis. A new ContributorFact is created for each Project 
 * contributor whenever a new Analysis is created for the Project.
 * ContributorFacts only exist after Ohloh has downloaded and analyzed the project source code.
 * 
 */
@XmlRootElement(name="contributor_fact")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContributorFact {

    @XmlElement(name = "analysis_id")
    protected String analysisId;
    
    @XmlElement(name = "contributor_id")
    protected String contributorId;
    
    @XmlElement(name = "contributor_name")
    protected String contributorName;
    
    @XmlElement(name = "account_id")
    protected String accountId;
    
    @XmlElement(name = "account_name")
    protected String accountName;
    
    @XmlElement(name = "primary_language_id")
    protected String primaryLanguageId;
    
    @XmlElement(name = "primary_language_nice_name")
    protected String primaryLanguageNiceName;
    
    @XmlElement(name = "comment_ratio")
    protected String commentRatio;
    
    @XmlElement(name = "first_commit_time")
    @XmlJavaTypeAdapter(DateAdapter.class)
    protected Date firstCommitTime;
    
    @XmlElement(name = "last_commit_time")
    @XmlJavaTypeAdapter(DateAdapter.class)
    protected Date lastCommitTime;
    
    @XmlElement(name = "man_months")
    protected Integer manMonths;
    
    @XmlElement
    protected Integer commits;
    
    @XmlElementWrapper(name="contributor_language_facts")
    @XmlElement(name="contributor_language_fact")
    protected List<ContributorLanguageFact> contributorLanguageFacts;

    /**
     * The unique ID for the Analysis which provided the source data for this ContributorFact.
     * 
     */
    public String getAnalysisId() {
        return analysisId;
    }

    /**
     * The ID for the person who contributed the code measured in this ContributorFact. 
     * The `contributor_id` is not globally unique. It is derived from the author name found in the source control server log, 
     * and is unique within the scope of an individual project only.
     * 
     */
    public String getContributorId() {
        return contributorId;
    }

    /**
     * The name used by the author of this code when committing to the source control server.
     * 
     */
    public String getContributorName() {
        return contributorName;
    }

    /**
     * If this contribution has been claimed by an Ohloh member, the element contains the unique ID of the Ohloh Account). 
     * Otherwise, this element is omitted.
     * 
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * If this contribution has been claimed by an Ohloh member, this element contains the Account name. 
     * Otherwise, this element is omitted.
     * 
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * The unique ID of the Language most often used by this contributor, measured by the number of code lines added. 
     * If this contributor has not committed any code in a language which Ohloh can recognize, this value will be null.
     * 
     */
    public String getPrimaryLanguageId() {
        return primaryLanguageId;
    }

    /**
     * The `nice_name` of the Language specified by `primary_language_id`.
     * 
     */
    public String getPrimaryLanguageNiceName() {
        return primaryLanguageNiceName;
    }

    /**
     * The fraction of new lines added by this contributor which are comments. 
     * Note that Ohloh does not track the net lines of current code attributable to an specific individual. 
     * This statistic merely sums over all new lines added, and does not consider whether the added lines were 
     * later removed by this contributor or any other.
     * 
     */
    public String getCommentRatio() {
        return commentRatio;
    }

    /**
     * The time of the first commit by this contributor.
     * 
     */
    public Date getFirstCommitTime() {
        return firstCommitTime;
    }

    /**
     * The time of the last commit by this contributor.
     * 
     */
    public Date getLastCommitTime() {
        return lastCommitTime;
    }

    /**
     * The total number of calendar months in which this contributor made at least one commit. 
     * Note that this is not simply the number of months between `first_commit_time` and `last_commit_time`: 
     * months in which there was no activity for this contributor are not counted.
     * 
     */
    public Integer getManMonths() {
        return manMonths;
    }

    /**
     * The total number of commits made by this contributor.
     * 
     */
    public Integer getCommits() {
        return commits;
    }

	/**
	 * A collection of ContributorLanguageFacts may be included here, covering statistics in individual Languages. 
	 * This collection is only present when ContributorFacts are queried individually.
	 */
	public List<ContributorLanguageFact> getContributorLanguageFacts() {
		return contributorLanguageFacts;
	}

}
