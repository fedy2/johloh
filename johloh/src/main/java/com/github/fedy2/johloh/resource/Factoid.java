
package com.github.fedy2.johloh.resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * A Factoid is a short, high-level bullet point delivering a simple observation about a Project. 
 * Factoids are derived from an Analysis, and new Factoids are created for a Project every time a new Analysis is created.
 * On the Ohloh web site, Factoids are rendered in the Nutshell section of the project summary page. 
 * Factoids also are available in several of the sharing widgets available for embedding on websites.
 * A Project has factoids only if Ohloh has downloaded and analyzed its source code.
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Factoid {

    @XmlElement
    protected String id;
    
    @XmlElement(name = "analysis_id")
    protected String analysisId;
    
    @XmlElement
    protected FactoidType type;
    
    @XmlElement
    protected String description;
    
    @XmlElement
    protected Integer severity;

    /**
     * The unique ID for the Factoid. 
     * Factoid IDs change every time the Project is reanalyzed, so it’s unwise to store these IDs for long periods.
     * 
     */
    public String getId() {
        return id;
    }

    /**
     * The unique ID of the analysis used to calculate this factoid.
     * 
     */
    public String getAnalysisId() {
        return analysisId;
    }

    /**
     * The Factoid type.
     * 
     */
    public FactoidType getType() {
        return type;
    }

    /**
     * A short, human-readable description. 
     * This is the bullet point text which appears on the Ohloh project page.
     * 
     */
    public String getDescription() {
        return description;
    }

	/**
	 * An integer from -3 to +3 which rates the relative severity of the factoid. 
	 * Negative numbers generally indicate bad news, positive numbers generally indicate good news. 
	 * Ohloh uses these numbers to select icons to display beside the factoids. 
	 * All factoids of the same type have the save severity.
	 */
	public Integer getSeverity() {
		return severity;
	}
}
