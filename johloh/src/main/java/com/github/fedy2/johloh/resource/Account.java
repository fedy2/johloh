
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
import com.github.fedy2.johloh.rest.binding.IntegerAdapter;

/**
 * An Account represents an Ohloh member. Some Account data is private, and cannot be accessed through the Ohloh API.
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Account {

    @XmlElement
    protected String id;
    
    @XmlElement
    protected String name;
    
    @XmlElement
    protected String about;
    
    @XmlElement
    protected String login;
    
    @XmlElement(name = "created_at")
	@XmlJavaTypeAdapter(DateAdapter.class)
    protected Date createdAt;
    
    @XmlElement(name = "updated_at")
	@XmlJavaTypeAdapter(DateAdapter.class)
    protected Date updatedAt;
    
    @XmlElement(name = "homepage_url")
    protected String homepageUrl;
    
    @XmlElement(name = "twitter_account")
    protected String twitterAccount;
    
    @XmlElement
    protected String url;
    
    @XmlElement(name = "html_url")
    protected String htmlUrl;
    
    @XmlElement(name = "avatar_url")
    protected String avatarUrl;
    
    @XmlElement(name = "email_sha1")
    protected String emailSha1;
    
    @XmlElement(name = "posts_count")
    protected Integer postsCount;
    
    @XmlElement
    protected String location;
    
    @XmlElement(name = "country_code")
    protected String countryCode;
    
    @XmlElement
    protected Double latitude;
    
    @XmlElement
    protected Double longitude;
    
    @XmlElement(name = "kudo_score")
    protected KudoScore kudoScore;
    
    @XmlElementWrapper(name="languages")
    @XmlElement(type=AccountLanguage.class, name="language")
    protected List<AccountLanguage> languages;

    /**
     * The unique ID for the Account.
     * 
     */
    public String getId() {
        return id;
    }

    /**
     * The public name for this Account.
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * A short description about this account.
     * 
     */
    public String getAbout() {
        return about;
    }

    /**
     * The Login handle for this account.
     * 
     */
    public String getLogin() {
        return login;
    }

    /**
     * The time at which this Account was originally created on Ohloh.
     * 
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * The time at which this Account record was last modified.
     * 
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * An optional URL to a member’s home page, such as a blog.
     * 
     */
    public String getHomepageUrl() {
        return homepageUrl;
    }

    /**
     * An optional Twitter handle for this account.
     * 
     */
    public String getTwitterAccount() {
        return twitterAccount;
    }

    /**
     * A URL, returning details about this account in XML format.
     * 
     */
    public String getUrl() {
        return url;
    }

    /**
     * A URL to the profile's Home page for this account.
     * 
     */
    public String getHtmlUrl() {
        return htmlUrl;
    }

    /**
     * A URL to the profile image displayed on Ohloh pages. 
     * Currently, this is an URL to the Gravatar free image hosting service, which will resolves to a default 
     * image if the account holder is not a Gravatar member. Images are 80×80 by default.
     * 
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * The SHA1 hex digest of the account email address.
     * 
     */
    public String getEmailSha1() {
        return emailSha1;
    }

    /**
     * The number of posts made to the Ohloh forums by this account.
     * 
     */
    public Integer getPostsCount() {
        return postsCount;
    }

    /**
     * An optional text description of this account holder’s claimed location. 
     * This text has been validated by either the Google or Yahoo geocoder web service, 
     * but the precision is variable.
     * 
     */
    public String getLocation() {
        return location;
    }

    /**
     * A string representing the account holder’s country. 
     * This field is derived from location using either the Google or Yahoo geocoder web service. 
     * If you use this data, read the important note in the API documentation.
     * 
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Floating-point value representing the account’s latitude, suitable for use with the Google Maps API. 
     * It is available only when the account has specified a valid location.
     * 
     */
    public Double getLatitude() {
        return latitude;
    }
    
    /**
     * Floating-point value representing the account’s longitude, suitable for use with the Google Maps API. 
     * It is available only when the account has specified a valid location.
     * 
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * If this account has a KudoScore, it will appear here. 
     * New accounts may not have a KudoScore. 
     * The Ohloh seb site displays these accounts with a default KudoRank of 1.
     * 
     */
    public KudoScore getKudoScore() {
        return kudoScore;
    }

    /**
     * Only available when requesting an accounts details, this node will not be returned as part of a search result list. 
     * This node contains the total language experience for this account grouped by language.
     *  
     */
    public List<AccountLanguage> getLanguages() {
        return languages;
    }
    
    /**
     * The total language experience for this account grouped by language.
     * @author "Federico De Faveri defaveri@gmail.com"
     *
     */
    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class AccountLanguage {

        @XmlAttribute
        protected String color;
        
        @XmlElement
        protected String name;
        
        @XmlElement(name = "experience_months")
        @XmlJavaTypeAdapter(IntegerAdapter.class)
        protected Integer experienceMonths;
        
        @XmlElement(name="total_commits")
        @XmlJavaTypeAdapter(IntegerAdapter.class)
        protected Integer totalCommits;
        
        @XmlElement(name="total_lines_changed")
        @XmlJavaTypeAdapter(IntegerAdapter.class)
        protected Integer totalLinesChanged;
        
        @XmlElement(name = "comment_ratio")
        protected String commentRatio;

		/**
		 * This is the Ohloh color code for this language. 
		 * If you will be displaying this data in your application it is highly recommended you use 
		 * the colors returned here as these are the same colors Ohloh uses to display specific languages.
		 */
		public String getColor() {
			return color;
		}

		/**
		 * The Ohloh code name for this language, e.g. C# will be csharp and C++ will be cpp.
		 */
		public String getName() {
			return name;
		}

		/**
		 * The total number of months that Ohloh has computed as experience in this language for the current Account.
		 */
		public Integer getExperienceMonths() {
			return experienceMonths;
		}

		/**
		 * The total number of commits made by the current Account that contained code in the current Language.
		 */
		public Integer getTotalCommits() {
			return totalCommits;
		}

		/**
		 * The total number of lines changed by the current Account that contained code in the current Language.
		 */
		public Integer getTotalLinesChanged() {
			return totalLinesChanged;
		}

		/**
		 * The ratio of comment lines to code lines in commits made by the current Account for the current Language.
		 */
		public String getCommentRatio() {
			return commentRatio;
		}
    }
}
