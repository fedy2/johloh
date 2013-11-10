
package com.github.fedy2.johloh.resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Every night, a KudoScore is generated for every Ohloh Account and Project contributor (collectively called ‘participants’ here). These scores are derived from the [Kudos](kudo.md) sent between participants. You can read a general outline of the KudoRank algorithm [here](http://meta.ohloh.net/kudos/).Not everyone has a KudoScore. Because KudoScores are calculated only once per day, new Accounts and contributors may not have a kudo score. On the Ohloh web site, unscored Accounts and contributors are displayed with a default KudoRank of 1.
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class KudoScore {

    @XmlElement(name = "kudo_rank")
    public Integer kudoRank;
    
    @XmlElement
    public Integer position;

    /**
     * The KudoRank, which is an integer from 1 to 10. Higher ranks are better. 
     * KudoRanks are assigned on a curve, with a certain fraction of people receiving each KudoRank.
     * 
     */
    public Integer getKudoRank() {
        return kudoRank;
    }

	/**
	 * An integer which orders all participants. 
	 * The person with position equals 1 is the highest-ranked person on Ohloh.
	 */
	public Integer getPosition() {
		return position;
	}
}
