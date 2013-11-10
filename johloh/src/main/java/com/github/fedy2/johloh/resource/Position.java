
package com.github.fedy2.johloh.resource;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.github.fedy2.johloh.rest.binding.DateAdapter;


/**
 * A position represents a contribution or series of contributions that an account holder has made to a project within Ohloh. 
 * It corresponds to a committer ID for a source code repository for a particular project.
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Position {

    @XmlElement
    protected String title;
    
    @XmlElement
    protected String organization;
    
    @XmlElement(name = "html_url")
    protected String htmlUrl;
    
    @XmlElement(name = "created_at")
    @XmlJavaTypeAdapter(DateAdapter.class)
    protected Date createdAt;
    
    @XmlElement(name = "updated_at")
    @XmlJavaTypeAdapter(DateAdapter.class)
    protected Date updatedAt;
    
    @XmlElement(name = "started_at")
    @XmlJavaTypeAdapter(DateAdapter.class)
    protected Date startedAt;
    
    @XmlElement(name = "ended_at")
    @XmlJavaTypeAdapter(DateAdapter.class)
    protected Date endedAt;
    
    @XmlElement(name = "sparkline_url")
    protected String sparklineUrl;
    
    @XmlElement
    protected Integer commits;
    
    @XmlElement
    protected Project project;

    /**
     * An optional field that contains the title for this position. 
     * Example: “Lead Developer”. This field is filled in by the account holder.
     * 
     */
    public String getTitle() {
        return title;
    }

    /**
     * An optional field that contains the organization name for this position. 
     * This field will be filled in if the account holder has designated that this position’s contributions were made on behalf of an organization. 
     * Example: “IBM Corporation”.
     * 
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * The url to the contributor page on Ohloh.
     * 
     */
    public String getHtmlUrl() {
        return htmlUrl;
    }

    /**
     * The time at which this Position was originally created on Ohloh.
     * 
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * The time at which this Position record was last modified.
     * 
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Optional field that contains the time at which this position was started. 
     * This field may be filled in by the account holder if this position is not backed by commits 
     * (e.g. the user contributed documentation to the projects wiki or authored and submitted a patch committed by a project maintainer).
     * 
     */
    public Date getStartedAt() {
        return startedAt;
    }

    /**
     * Option field that contains the time at which this position was ended. 
     * This field may be filled in by the account holder if the position is not backed by commits.
     * 
     */
    public Date getEndedAt() {
        return endedAt;
    }

    /**
     * The url to the sparkline that represents the account holder’s commit activity for the current position.
     * 
     */
    public String getSparklineUrl() {
        return sparklineUrl;
    }

    /**
     * The total number of commits made by the account holder at this position.
     * 
     */
    public Integer getCommits() {
        return commits;
    }

	/**
	 * The Project that this position is attached to. 
	 */
	public Project getProject() {
		return project;
	}

}
