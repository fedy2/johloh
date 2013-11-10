
package com.github.fedy2.johloh.resource;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.github.fedy2.johloh.rest.binding.DateAdapter;


/**
 * An Analysis is a pre-computed collection of statistics about Project source code and contributors.
 * An individual Analysis never changes. When a Project’s source code is modified, a completely new Analysis is generated for that Project. 
 * Eventually, old analyses are deleted from the database. 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Analysis {

    @XmlElement
    protected String id;
    
    @XmlElement
    protected String url;
    
    @XmlElement(name = "project_id")
    protected String projectId;
    
    @XmlElement(name = "updated_at")
    @XmlJavaTypeAdapter(DateAdapter.class)
    protected Date updatedAt;
    
    @XmlElement(name = "logged_at")
    @XmlJavaTypeAdapter(DateAdapter.class)
    protected Date loggedAt;
    
    @XmlElement(name = "min_month")
    protected String minMonth;
    
    @XmlElement(name = "max_month")
    protected String maxMonth;
    
    @XmlElement(name = "twelve_month_contributor_count")
    protected Integer twelveMonthContributorCount;
    
    @XmlElement(name = "total_contributor_count")
    protected Integer totalContributorCount;
    
    @XmlElement(name = "twelve_month_commit_count")
    protected Integer twelveMonthCommitCount;
    
    @XmlElement(name = "total_commit_count")
    protected Integer totalCommitCount;
    
    @XmlElement(name = "total_code_lines")
    protected List<String> totalCodeLines;
    
    @XmlElement(name = "main_language_id")
    protected String mainLanguageId;
    
    @XmlElement(name = "main_language_name")
    protected String mainLanguageName;
    
    @XmlElementWrapper(name="factoids")
    @XmlElement(type=ShortFactoid.class, name="factoid")
    protected List<ShortFactoid> factoids;
    
    @XmlElement(type=Languages.class)
    protected Languages languages;

    /**
     * The unique ID for the Analysis.
     * 
     */
    public String getId() {
        return id;
    }

    /**
     * A URL, returning details about this Analysis in XML format.
     * 
     */
    public String getUrl() {
        return url;
    }

    /**
     * The unique ID of the Project measured by this Analysis.
     * 
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * The time at which this Analysis record was last modified.
     * 
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * The time at which Ohloh queried the source control system for the source code measured by this Analysis. 
     * All commits which occured at or before this time are included. 
     * Note that the Analysis might also include some activity after this time if the project includes many Repositories, 
     * because not all Repositories are updated at the same time. 
     * The logged_at time is the most pessimistic time among all the Repositories included in the Project.
     * 
     */
    public Date getLoggedAt() {
        return loggedAt;
    }

    /**
     * Ohloh groups most historical statistics ActivityFacts and SizeFacts into monthly totals. 
     * min_month indicates the first month for which Ohloh has monthly historical statistics available for this project. 
     * This is typically the date of the first project commit, truncated to the beginning of its calendar month. 
     * Only the year and month fields are significant.
     * 
     */
    public String getMinMonth() {
        return minMonth;
    }

    /**
     * The last month for which monthly historical statistics are available for this project. 
     * Depending on when this analysis was prepared, max_month usually refers to the current month, 
     * but it may be slightly older. Only the year and month fields are significant. 
     * Ohloh’s monthly statistics for max_month are usually smaller than other months because 
     * the complete month has not yet elapsed, and it reflects ongoing development work.
     * 
     */
    public String getMaxMonth() {
        return maxMonth;
    }

    /**
     * The number of contributors who made at least one commit to the project source code 
     * in the twelve months leading up to and including `max_month`.
     * 
     */
    public Integer getTwelveMonthContributorCount() {
        return twelveMonthContributorCount;
    }

    /**
     * The total number of contributors who made at least one commit to the project source code 
     * leading up to and including `max_month`.
     * 
     */
    public Integer getTotalContributorCount() {
        return totalContributorCount;
    }

    /**
     * The number of commits to the project source code in the twelve months leading up to and including `max_month`.
     * 
     */
    public Integer getTwelveMonthCommitCount() {
        return twelveMonthCommitCount;
    }

    /**
     * The total number of commits to the project source code leading up to and including `max_month`.
     * 
     */
    public Integer getTotalCommitCount() {
        return totalCommitCount;
    }

    /**
     * The most recent total count of all source code lines. Blank lines and comment lines are excluded.
     * 
     */
    public List<String> getTotalCodeLines() {
        return totalCodeLines;
    }

    /**
     * The unique ID of the most common programming language used in this project. XML and HTML are ignored when making this determination.
     * 
     */
    public String getMainLanguageId() {
        return mainLanguageId;
    }

    /**
     * The name of the most common programming language used in this project. XML and HTML are ignored when making this determination.
     * 
     */
    public String getMainLanguageName() {
        return mainLanguageName;
    }

    /**
     * The factoids for the current Analysis will be included under this node.
     * 
     */
    public List<ShortFactoid> getFactoids() {
        return factoids;
    }

    /**
     * The language breakdown chart for the current Analysis will be included under this node.
     * 
     */
    public List<ShortLanguage> getLanguages() {
        return languages.getItems();
    }
    
    /**
     * This is the url to the PNG image that depicts the language breakdown for the current Analysis. 
     * The colors referenced in each languages color attribute will be used in this image.
     */
    public String getLanguagesGraphUrl()
    {
    	return languages.getGraphUrl();
    }

    @XmlRootElement
    public static class Languages {
    	
    	@XmlAttribute(name="graph_url")
    	protected String graphUrl;
    	 
    	@XmlElement(name="language")
        protected List<ShortLanguage> items;
     
        public List<ShortLanguage> getItems() {
            return items;
        }

		/**
		 * @return the graphUrl
		 */
		public String getGraphUrl() {
			return graphUrl;
		}
    }
}
