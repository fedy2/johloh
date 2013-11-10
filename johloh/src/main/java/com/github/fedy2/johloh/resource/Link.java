
package com.github.fedy2.johloh.resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The links associated with a project.
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Link {

    @XmlElement
    protected String category;
    
    @XmlElement
    protected String title;
    
    @XmlElement
    protected String url;

    /**
     * Link category on Ohloh
     * 
     */
    public String getCategory() {
        return category;
    }

    /**
     * 
     * 
     */
    public String getTitle() {
        return title;
    }

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
}
