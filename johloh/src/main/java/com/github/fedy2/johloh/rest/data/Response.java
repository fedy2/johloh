/**
 * 
 */
package com.github.fedy2.johloh.rest.data;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.github.fedy2.johloh.resource.Account;
import com.github.fedy2.johloh.resource.ActivityFact;
import com.github.fedy2.johloh.resource.Analysis;
import com.github.fedy2.johloh.resource.ContributorFact;
import com.github.fedy2.johloh.resource.Enlistment;
import com.github.fedy2.johloh.resource.Factoid;
import com.github.fedy2.johloh.resource.Kudo;
import com.github.fedy2.johloh.resource.Language;
import com.github.fedy2.johloh.resource.Position;
import com.github.fedy2.johloh.resource.Project;
import com.github.fedy2.johloh.resource.SizeFact;
import com.github.fedy2.johloh.resource.Stack;

/**
 * Represents a service response.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Project.class, Account.class, ActivityFact.class, Analysis.class, ContributorFact.class, 
	Enlistment.class, Factoid.class, Kudo.class, Language.class, Position.class, SizeFact.class, Stack.class})
public class Response<T> {
	
	@XmlElement
	protected String status;
	
	@XmlElement
	protected String error;
	
	@XmlElement(name="items_returned")
	protected Integer itemsReturned;
	
	@XmlElement(name="items_available")
	protected Integer itemsAvailable;
	
	@XmlElement(name="first_item_position")
	protected Integer firstItemPosition;
	
	@XmlElement
	protected Wrapper<T> result;
	
	/**
	 * Returns the response status.
	 * The value can be success or failed.
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Returns the response error in case of failure, <code>null</code> otherwise.
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	
	/**
	 * The number of items returned in this response.
	 * @return the itemsReturned
	 */
	public Integer getItemsReturned() {
		return itemsReturned;
	}

	/**
	 * The total number of database items matching the query, including those already returned.
	 * @return the itemsAvailable
	 */
	public Integer getItemsAvailable() {
		return itemsAvailable;
	}

	/**
	 * The zero-based index of the first item returned
	 * @return the firstItemPosition
	 */
	public Integer getFirstItemPosition() {
		return firstItemPosition;
	}

	/**
	 * Return the results elements.
	 * @return the result
	 */
	public List<T> getResults() {
		return result.getItems();
	}

	/**
	 * Returns first result element.
	 * @return the result
	 */
	public T getResult() {
		return result.getItems().get(0);
	}

	/** 
	 * {@inheritDoc} 
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Response [status=");
		builder.append(status);
		builder.append(", error=");
		builder.append(error);
		builder.append(", itemsReturned=");
		builder.append(itemsReturned);
		builder.append(", itemsAvailable=");
		builder.append(itemsAvailable);
		builder.append(", firstItemPosition=");
		builder.append(firstItemPosition);
		builder.append(", result=");
		builder.append(result);
		builder.append("]");
		return builder.toString();
	}
}
