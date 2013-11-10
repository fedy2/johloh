
package com.github.fedy2.johloh.resource;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * A Language record contains the name and various statistics related to a programming language.
 * Language statistics are updated daily.
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Language {

    @XmlElement
    protected String id;
    
    @XmlElement
    protected String name;
    
    @XmlElement(name = "nice_name")
    protected String niceName;
    
    @XmlElement
    protected String category;
    
    @XmlElement
    protected String code;
    
    @XmlElement
    protected List<String> comments;
    
    @XmlElement
    protected List<String> blanks;
    
    @XmlElement(name = "comment_ratio")
    protected Double commentRatio;
    
    @XmlElement
    protected Integer projects;
    
    @XmlElement
    protected Integer contributors;
    
    @XmlElement
    protected Integer commits;

    /**
     * The unique ID of the language.
     * 
     */
    public String getId() {
        return id;
    }

    /**
     * A short, unique name for the language. Primarily for internal Ohloh use.
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * A human-friendly name for the language.
     * 
     */
    public String getNiceName() {
        return niceName;
    }

    /**
     * Either code, markup, or build, which indicates that the language is either a “standard” programming language, 
     * a document markup language such as XML, or a build script such as a makefile.
     * 
     */
    public String getCategory() {
        return category;
    }

    /**
     * The total net lines of code, excluding comments and blank lines, written in this language across all projects on Ohloh.
     * 
     */
    public String getCode() {
        return code;
    }

    /**
     * The total net comment lines written in this language across all projects on Ohloh.
     * 
     */
    public List<String> getComments() {
        return comments;
    }

    /**
     * The total net blank lines in this language across all projects on Ohloh.
     * 
     */
    public List<String> getBlanks() {
        return blanks;
    }

    /**
     * A precomputed floating-point value for the percent of lines in this language that are comments, across all projects on Ohloh.
     * 
     */
    public Double getCommentRatio() {
        return commentRatio;
    }

    /**
     * The total number of Projects on Ohloh which currently include at least one line in this language.
     * 
     */
    public Integer getProjects() {
        return projects;
    }

    /**
     * The total number of contributors on Ohloh who have written at least one line of code in this language that still exists today.
     * 
     */
    public Integer getContributors() {
        return contributors;
    }

	/**
	 * The total number of commits on Ohloh which include at least one line in this language.
	 */
	public Integer getCommits() {
		return commits;
	}
}
