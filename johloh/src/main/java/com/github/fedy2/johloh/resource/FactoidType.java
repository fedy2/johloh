/**
 * 
 */
package com.github.fedy2.johloh.resource;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.github.fedy2.johloh.rest.binding.FactoidTypeAdapter;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
@XmlJavaTypeAdapter(FactoidTypeAdapter.class)
public enum FactoidType {

	/**
	 *  During the last twelve calendar months, there were at least 25% fewer commits to this project than in the prior twelve calendar months.
	 */
	FACTOID_ACTIVITY_DECREASING("FactoidActivityDecreasing"),

	/**
	 *  During the last twelve calendar months, the commit count was within +/- 25% of the count for the prior twelve calendar months.
	 */
	FACTOID_ACTIVITY_STABLE("FactoidActivityStable"),

	/**
	 *  During the last twelve calendar months, there were at least 25% more commits to this project than in the prior twelve calendar months.
	 */
	FACTOID_ACTIVITY_INCREASING("FactoidActivityIncreasing"),

	/**
	 *  The source control repository is less than 1 year old.
	 */
	FACTOID_AGE_YOUNG("FactoidAgeYoung"),

	/**
	 *  The source control repository is 1 to 3 years old.
	 */
	FACTOID_AGE_ESTABLISHED("FactoidAgeEstablished"),

	/**
	 *  The source control repository is 3 to 5 years old.
	 */
	FACTOID_AGE_OLD("FactoidAgeOld"),

	/**
	 *  The source control repository is 5 years old or older.
	 */
	FACTOID_AGE_VERY_OLD("FactoidAgeVeryOld"),

	/**
	 *  Compared to all other projects written in the same language, the comment ratio for this project is in the bottom 10%.
	 */
	FACTOID_COMMENTS_VERY_LOW("FactoidCommentsVeryLow"),

	/**
	 *  Compared to all other projects written in the same language, the comment ratio for this project is in the bottom 33% but not in the bottom 10%.
	 */
	FACTOID_COMMENTS_LOW("FactoidCommentsLow"),

	/**
	 *  Compared to all other projects written in the same language, the comment ratio for this project is in the middle 33%.
	 */
	FACTOID_COMMENTS_AVERAGE("FactoidCommentsAverage"),

	/**
	 *  Compared to all other projects written in the same language, the comment ratio for this project is in the top 33% but not in the top 10%.
	 */
	FACTOID_COMMENTS_HIGH("FactoidCommentsHigh"),

	/**
	 *  Compared to all other projects written in the same language, the comment ratio for this project is in the top 10%.
	 */
	FACTOID_COMMENTS_VERY_HIGH("FactoidCommentsVeryHigh"),

	/**
	 *  No commits were made to this project in the last 12 months.
	 */
	FACTOID_TEAM_SIZE_ZERO("FactoidTeamSizeZero"),

	/**
	 *  Only a single contributor made commits to this project in the last 12 months.
	 */
	FACTOID_TEAM_SIZE_ONE("FactoidTeamSizeOne"),

	/**
	 *  Two or three contributors made commits to this project in the last 12 months.
	 */
	FACTOID_TEAM_SIZE_SMALL("FactoidTeamSizeSmall"),

	/**
	 *  4 to 6 contributors made commits to this project in the last 12 months.
	 */
	FACTOID_TEAM_SIZE_AVERAGE("FactoidTeamSizeAverage"),

	/**
	 *  7 to 27 contributors made commits to this project in the last 12 months.
	 */
	FACTOID_TEAM_SIZE_LARGE("FactoidTeamSizeLarge"),

	/**
	 *  28 or more contributors made commits to this project in the last 12 months.
	 */
	FACTOID_TEAM_SIZE_VERY_LARGE("FactoidTeamSizeVeryLarge");

	static Map<String, FactoidType> index;

    static
    {
    	index = new HashMap<>();
        for (FactoidType type : FactoidType.values()) index.put(type.getTypeName(), type);
    }
	
	private String typeName;

	/**
	 * @param typeName
	 */
	private FactoidType(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}
	
	public static FactoidType getType(String typeName)
	{
		return index.get(typeName);
	}
}
