
package com.github.fedy2.johloh.resource;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.github.fedy2.johloh.rest.binding.DateAdapter;


/**
 * A Stack represents a collection of Projects used by a single person. 
 * A Stack belongs to an Account. A Stack contains zero or more StackEntries, each of which links the Stack to a single Project.
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Stack {

    @XmlElement
    protected String id;
    
    @XmlElement
    protected String title;
    
    @XmlElement
    protected String description;
    
    @XmlElement(name = "updated_at")
    @XmlJavaTypeAdapter(DateAdapter.class)
    protected Date updatedAt;
    
    @XmlElement(name = "project_count")
    protected Integer projectCount;
    
    @XmlElementWrapper(name="stack_entries")
    @XmlElement(name="stack_entry")
    protected List<StackEntry> stackEntries;
    
    @XmlElement(name = "account_id")
    protected String accountId;
    
    @XmlElement
    protected Account account;

    /**
     * The unique ID for the Stack.
     * 
     */
    public String getId() {
        return id;
    }

    /**
     * The name of the Stack.
     * 
     */
    public String getTitle() {
        return title;
    }

    /**
     * A short description about this Stack.
     * 
     */
    public String getDescription() {
        return description;
    }

    /**
     * The most recent time at which any Projects were added to or removed from this Stack.
     * 
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * The total number of Projects currently contained in this Stack.
     * 
     */
    public Integer getProjectCount() {
        return projectCount;
    }

    /**
     * A collection of zero or more StackEntries. 
     * If the Stack object was returned in response to a collection request, 
     * you will receive only a single StackEntry corresponding to the Project in question.
     * 
     */
    public List<StackEntry> getStackEntries() {
        return stackEntries;
    }

    /**
     * The unique ID of the Account which owns this Stack.
     * 
     */
    public String getAccountId() {
        return accountId;
    }

	/**
	 * For convenience, a full Account object may be included here. 
	 * If the stack object was returned in response to a collection request, 
	 * the Account objects will be present.
	 */
	public Account getAccount() {
		return account;
	}

}
