
package com.github.fedy2.johloh.resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * An Enlistment joins a Project to a source control Repository.
 * Once added to the Ohloh database, a Repository is permanent. 
 * However, Enlistments to that Repository may be added or removed at any time. 
 * Many Projects may share a single Repository.
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Enlistment {

    @XmlElement
    protected String id;
    
    @XmlElement(name = "project_id")
    protected String projectId;
    
    @XmlElement(name = "repository_id")
    protected String repositoryId;
    
    @XmlElement
    protected Repository repository;

    /**
     * The unique ID of the Enlistment.
     * 
     */
    public String getId() {
        return id;
    }

    /**
     * The unique ID of the Project.
     * 
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * The unique ID of the Repository.
     * 
     */
    public String getRepositoryId() {
        return repositoryId;
    }

	/**
	 * The Repository record will be included in full here.
	 */
	public Repository getRepository() {
		return repository;
	}

}
