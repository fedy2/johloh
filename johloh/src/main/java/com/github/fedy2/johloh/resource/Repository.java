
package com.github.fedy2.johloh.resource;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.github.fedy2.johloh.rest.binding.DateAdapter;

/**
 * A Repository represents an individual source control repository. 
 * Once added to the Ohloh database, a Repository is permanent and unique. 
 * A Repository is added to a Project by creating an Enlistment, which links the Project to the Repository. 
 * In this way, many Projects can share the same Repository. Deleting an Enlistment from a Project does not delete a Repository, 
 * nor will it interrupt Ohloh download activity against that Repository. 
 * The Repository and all of its source code and metrics remain in the Ohloh database; only the Enlistment link is modified.
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Repository {

    @XmlElement
    protected String id;
    
    @XmlElement
    protected RepositoryType type;
    
    @XmlElement
    protected String url;
    
    @XmlElement(name = "module_name")
    protected String moduleName;
    
    @XmlElement
    protected String username;
    
    @XmlElement
    protected String password;
    
    @XmlElement(name = "logged_at")
    @XmlJavaTypeAdapter(DateAdapter.class)
    protected Date loggedAt;
    
    @XmlElement
    protected Integer commits;
    
    @XmlElement(name="ohloh_job_status")
    protected String ohlohJobStatus;

    /**
     * The unique ID of the Repository.
     * 
     */
    public String getId() {
        return id;
    }

    /**
     * The source control type.
     * 
     */
    public RepositoryType getType() {
        return type;
    }

    /**
     * The public URL for the source control server.
     * 
     */
    public String getUrl() {
        return url;
    }

    /**
     * For CVS repositories only, this is the module name. 
     * For all other repository types, this element is omitted.
     * 
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * An optional username, if one is required to access the source control server.
     * 
     */
    public String getUsername() {
        return username;
    }

    /**
     * An optional password, if one is required to access the source control server.
     * 
     */
    public String getPassword() {
        return password;
    }

    /**
     * The last time the Ohloh servers successfully queried the source control server for changes.
     * 
     */
    public Date getLoggedAt() {
        return loggedAt;
    }

    /**
     * The number of commits which the Ohloh servers have successfully downloaded from the source control server.
     * 
     */
    public Integer getCommits() {
        return commits;
    }

	/**
	 * If the most recent attempt by Ohloh to query the source control server for changes failed or was interrupted, this value will be failed. 
	 * In all other cases it is success.
	 */
	public String getOhlohJobStatus() {
		return ohlohJobStatus;
	}
}
