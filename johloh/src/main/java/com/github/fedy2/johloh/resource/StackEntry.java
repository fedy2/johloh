
package com.github.fedy2.johloh.resource;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.github.fedy2.johloh.rest.binding.DateAdapter;


/**
 * A StackEntry joins a Stack to a Project.
 * 
 */
@XmlRootElement(name="stack_entry")
@XmlAccessorType(XmlAccessType.FIELD)
public class StackEntry {

    @XmlElement
    public String id;
    
    @XmlElement(name = "created_at")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date createdAt;
    
    @XmlElement(name = "stack_id")
    public String stackId;
    
    @XmlElement(name = "project_id")
    public String projectId;
    
    @XmlElement
    public Project project;

    /**
     * The unique ID for the StackEntry.
     * 
     */
    public String getId() {
        return id;
    }

    /**
     * The time at which this Project was added to this Stack.
     * 
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * The unique ID of the Stack which contains this StackEntry.
     * 
     */
    public String getStackId() {
        return stackId;
    }

    /**
     * The unique ID of the Project.
     * 
     */
    public String getProjectId() {
        return projectId;
    }

	/**
	 * For convenience, a full Project object may be included here. 
	 * If the Stack object was returned in response to an Account Stack request, the Project objects will be present.
	 */
	public Project getProject() {
		return project;
	}
}
