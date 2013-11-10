
package com.github.fedy2.johloh.resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * A ContributorLanguageFact contains a selection of Language-specific statistics about a single person who commited source code to a Project.
 * One ContributorFact record exists for each Language used by a contributor. The ContributorLanguageFact is very similar 
 * to a ContributorFact. The difference is that a ContributorLanguageFact contains statistics for a particular Language only, 
 * while a ContributorFact contains summary statistics across all languages used by the contributor.
 * A ContributorLanguageFact is part of an Analysis, and is derived from lower-level statistics contained within 
 * the Analysis. New ContributorLanguageFacts are created for each Project contributor whenever a new Analysis is created 
 * for the Project. ContributorLanguageFacts only exist after Ohloh has downloaded and analyzed the project source code.
 * 
 */
@XmlRootElement(name="contributor_language_fact")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContributorLanguageFact {

    @XmlElement(name = "analysis_id")
    protected String analysisId;
    
    @XmlElement(name = "contributor_id")
    protected String contributorId;
    
    @XmlElement(name = "contributor_name")
    protected String contributorName;
    
    @XmlElement(name = "language_id")
    protected String languageId;
    
    @XmlElement(name = "language_nice_name")
    protected String languageNiceName;
    
    @XmlElement(name = "comment_ratio")
    protected String commentRatio;
    
    @XmlElement(name = "man_months")
    protected Integer manMonths;

    /**
     * The unique ID for the Analysis which provided the source data for this ContributorFact.
     * 
     */
    public String getAnalysisId() {
        return analysisId;
    }

    /**
     * The ID for the person who contributed the code measured in this ContributorLanguageFact. 
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
     * The unique ID of the Language measured.
     * 
     */
    public String getLanguageId() {
        return languageId;
    }

    /**
     * The `nice_name` of the Language measured.
     * 
     */
    public String getLanguageNiceName() {
        return languageNiceName;
    }

    /**
     * The fraction of new lines added by this contributor in this language which are comments. 
     * Note that Ohloh does not track the net lines of current code attributable to an specific individual. 
     * This statistic merely sums over all new lines added, and does not consider whether the added lines were 
     * later removed by this contributor or any other.
     * 
     */
    public String getCommentRatio() {
        return commentRatio;
    }

    /**
     * The total number of calendar months in which this contributor made at least one commit using this Language. 
     * Months in which there was no activity in this Language for this contributor are not counted.
     * 
     */
    public Integer getManMonths() {
        return manMonths;
    }

}
