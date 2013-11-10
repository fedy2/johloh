
package com.github.fedy2.johloh.resource;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.github.fedy2.johloh.resource.License;
import com.github.fedy2.johloh.resource.Link;
import com.github.fedy2.johloh.rest.binding.DateAdapter;


/**
 * A Project represents a collection of source code, documentation, and web sites treated together as a unit. 
 * It’s what most people might call an ‘application’ or ‘library’.
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Project {

	@XmlElement
	protected String id;
	
	@XmlElement
	protected String name;
	
	@XmlElement(name = "created_at")
	@XmlJavaTypeAdapter(DateAdapter.class)
	protected Date createdAt;
	
	@XmlElement(name = "updated_at")
	@XmlJavaTypeAdapter(DateAdapter.class)
	protected Date updatedAt;
	
	@XmlElement
	protected String description;
	
	@XmlElement(name = "homepage_url")
	protected String homepageUrl;
	
	@XmlElement(name = "download_url")
	protected String downloadUrl;
	
	@XmlElement(name = "url_name")
	protected String urlName;
	
	@XmlElement(name = "medium_logo_url")
	protected String mediumLogoUrl;
	
	@XmlElement(name = "small_logo_url")
	protected String smallLogoUrl;
	
	@XmlElement(name = "user_count")
	protected Integer userCount;
	
	@XmlElement(name = "average_rating")
	protected Float averageRating;
	
	@XmlElement(name = "rating_count")
	protected Integer ratingCount;
	
	@XmlElement(name = "review_count")
	protected Integer reviewCount;
	
	@XmlElement(name = "analysis_id")
	protected String analysisId;
	
	@XmlElement
	protected Analysis analysis;
	
	@XmlElement
	protected String url;
	
	@XmlElement(name = "html_url")
	protected String htmlUrl;
	
	@XmlElement
	protected List<ShortFactoid> factoids;
	
    @XmlElementWrapper(name="tags")
    @XmlElement(name="tag")
	protected List<String> tags;
	
    @XmlElement
	protected List<ShortLanguage> languages;
	
    @XmlElementWrapper(name="licenses")
    @XmlElement(name="license")
	protected List<License> licenses;
	
    @XmlElementWrapper(name="links")
    @XmlElement(name="link")
	protected List<Link> links;

	/**
	 * The unique ID for the Project.
	 * 
	 */
	public String getId() {
		return id;
	}

	/**
	 * The project name. Currently limited to 40 characters, and must be unique on Ohloh.
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * The time at which this Project was initially added to the Ohloh database.
	 * 
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * The time of the most recent modification of this Project record.
	 * 
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * An optional description. Currently limited to 800 characters.
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * An optional URL to the project home page.
	 * 
	 */
	public String getHomepageUrl() {
		return homepageUrl;
	}

	/**
	 * An optional URL to a website hosting project downloads.
	 * 
	 */
	public String getDownloadUrl() {
		return downloadUrl;
	}

	/**
	 * A short, unique name for this project. This name is used in Ohloh URLs.
	 * 
	 */
	public String getUrlName() {
		return urlName;
	}

	/**
	 * An url to the project’s 64×64 pixels logo image.
	 * 
	 */
	public String getMediumLogoUrl() {
		return mediumLogoUrl;
	}

	/**
	 * An url to the project’s 32×32 pixels logo image.
	 * 
	 */
	public String getSmallLogoUrl() {
		return smallLogoUrl;
	}

	/**
	 * The number of users currently using this project.
	 * 
	 */
	public Integer getUserCount() {
		return userCount;
	}

	/**
	 * A floating point value from 1.0 to 5.0, representing the average value of all user ratings. 
	 * 1.0 is the worst possible rating and 5.0 is the highest possible rating. 
	 * Will be null if no users have rated this project.
	 * 
	 */
	public Float getAverageRating() {
		return averageRating;
	}

	/**
	 * The number of users who have rated this project.
	 * 
	 */
	public Integer getRatingCount() {
		return ratingCount;
	}

	/**
	 * The number of users who have reviewed this project.
	 * 
	 */
	public Integer getReviewCount() {
		return reviewCount;
	}

	/**
	 * The unique ID of the current best [Analysis](analysis.md) for this project. 
	 * If the project has never been analyzed, this element will be empty.
	 * 
	 */
	public String getAnalysisId() {
		return analysisId;
	}

	/**
	 * For convenience, the current best Analysis for the project is included in this element. 
	 * This object is present only when you have requested a single project.
	 * if the project was returned as part of a collection, the analysis object will not be present.
	 * 
	 */
	public Analysis getAnalysis() {
		return analysis;
	}

	/**
	 * The xml api url for the current Project.
	 * 
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * The url to the current Projects details page on Ohloh.
	 * 
	 */
	public String getHtmlUrl() {
		return htmlUrl;
	}

	/**
	 * The factoids for the current project.
	 * 
	 */
	public List<ShortFactoid> getFactoids() {
		return factoids;
	}

	/**
	 * The tags for the current project.
	 * 
	 */
	public List<String> getTags() {
		return tags;
	}

	/**
	 * The language breakdown chart for the current Analysis. 
	 * 
	 */
	public List<ShortLanguage> getLanguages() {
		return languages;
	}

	/**
	 * The Licenses for the current project.
	 * 
	 */
	public List<License> getLicenses() {
		return licenses;
	}

	/**
	 * The links associated with the current project. 
	 * Homepage and Download links are not included here.
	 * 
	 */
	public List<Link> getLinks() {
		return links;
	}

}
