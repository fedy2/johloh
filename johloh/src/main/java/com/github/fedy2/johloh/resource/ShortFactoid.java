/**
 * 
 */
package com.github.fedy2.johloh.resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShortFactoid {

	@XmlAttribute
	protected FactoidType type;

	@XmlValue
	protected String description;

	/**
	 * @return the type
	 */
	public FactoidType getType() {
		return type;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
}
