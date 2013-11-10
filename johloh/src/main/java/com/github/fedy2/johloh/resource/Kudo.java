
package com.github.fedy2.johloh.resource;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.github.fedy2.johloh.rest.binding.DateAdapter;


/**
 * A Kudo is a simple gesture of thanks, praise, or endorsement from an Ohloh account to another person. 
 * An account may send Kudos to as many people as desired. Kudos can be sent directly to another Ohloh account, 
 * or they may be sent to a contributor on a Project who does not have an Ohloh account. 
 * This flexibility makes Kudo records slightly complex. When a Kudo is sent directly to an Ohloh Account, 
 * the recipient is identified by `receiver_account_id`. When a Kudo is sent to a contributor on a Project who does not have an Account, 
 * the Kudo record contains both `contributor_id` and `project_id`, which together uniquely identify the recipient.
 * Ocassionally, an Ohloh Account holder may claim to be a Project contributor who has some existing Kudos. 
 * When this happens, the existing Kudos become linked to the Account, 
 * and the Kudos will now have all three properties: `receiver_account_id`, `contributor_id`, and `project_id`.
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Kudo {

    @XmlElement(name = "created_at")
    @XmlJavaTypeAdapter(DateAdapter.class)
    protected Date createdAt;
    
    @XmlElement(name = "sender_account_id")
    protected String senderAccountId;
    
    @XmlElement(name = "sender_account_name")
    protected String senderAccountName;
    
    @XmlElement(name = "receiver_account_id")
    protected String receiverAccountId;
    
    @XmlElement(name = "receiver_account_name")
    protected String receiverAccountName;
    
    @XmlElement(name = "project_id")
    protected String projectId;
    
    @XmlElement(name = "project_name")
    protected String projectName;
    
    @XmlElement(name = "contributor_id")
    protected String contributorId;
    
    @XmlElement(name = "contributor_name")
    protected String contributorName;

    /**
     * The time at which this Kudo was sent.
     * 
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * The unique ID of the Account sending this Kudo.
     * 
     */
    public String getSenderAccountId() {
        return senderAccountId;
    }

    /**
     * The name of the Account sending this Kudo.
     * 
     */
    public String getSenderAccountName() {
        return senderAccountName;
    }

    /**
     * If this Kudo can be linked to an Account, this is the unique ID of the Account receiving this Kudo. 
     * Otherwise, this element is omitted.
     * 
     */
    public String getReceiverAccountId() {
        return receiverAccountId;
    }

    /**
     * If this kudo can be linked to an Account, this is the name of the Account receiving this Kudo. 
     * Otherwise, this element is omitted.
     * 
     */
    public String getReceiverAccountName() {
        return receiverAccountName;
    }

    /**
     * If this Kudo was sent to a Project contributor instead of an Account, this is the unique ID of the Project. 
     * Otherwise, this element is omitted.
     * 
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * If this Kudo was sent to a Project contributor instead of an Account, this is the Project name. 
     * Otherwise, this element is omitted.
     * 
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * If this Kudo was sent to a Project contributor instead of an Account, this is the unique ID of the contributor. 
     * Otherwise, this element is omitted.
     * 
     */
    public String getContributorId() {
        return contributorId;
    }

	/**
	 * If this Kudo was sent to a Project contributor instead of an account, this is the name which appears in the source control logs. 
	 * Otherwise, this element is omitted.
	 */
	public String getContributorName() {
		return contributorName;
	}
}
