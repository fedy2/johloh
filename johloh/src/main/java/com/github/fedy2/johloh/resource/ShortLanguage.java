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
 * Not every language will have a entry. Ohloh will will combine languages that do not make up a significant percentage into a aggregate entry “N Other”. 
 * This entry can be identified by either its @color, always “000000″ or @id, always “”. Each language will contain the following data
 * @author "Federico De Faveri defaveri@gmail.com"

 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShortLanguage {

	@XmlAttribute
	protected String color;

	@XmlAttribute
	protected Integer percentage;

	@XmlAttribute
	protected String id;

	@XmlValue
	protected String name;

	/**
	 * The color code that Ohloh uses to represent this language on the website. 
	 * This color is also used in the language breakdown graph image.
	 */
	public String getColor() {
		return color;
	}

	/**
	 * The Ohloh code name for this language, e.g. C# will be csharp and C++ will be cpp.
	 */
	public String getName() {
		return name;
	}

	/**
	 * The percentage of lines of code that the current language represents in the current Analysis
	 */
	public Integer getPercentage() {
		return percentage;
	}

	/**
	 * The Ohloh language id.
	 */
	public String getId() {
		return id;
	}
}
