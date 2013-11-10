
package com.github.fedy2.johloh.resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Licenses for a project.
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class License {

    @XmlElement
    protected String name;
    
    @XmlElement(name="nice_name")
    protected String nicename;

    /**
     * Full Name of the License
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * A human-friendly name of the License
     * 
     */
    public String getNicename() {
        return nicename;
    }
}
