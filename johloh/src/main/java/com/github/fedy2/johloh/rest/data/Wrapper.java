/**
 * 
 */
package com.github.fedy2.johloh.rest.data;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A generic list wrapper.
 * @author "Federico De Faveri defaveri@gmail.com"
 * 
 * @param <T> the list type.
 */
@XmlRootElement
public class Wrapper<T> {
	 
    private List<T> items;
 
    /**
     * Creates an empty {@link Wrapper}.
     */
    public Wrapper() {
        items = new ArrayList<T>();
    }
 
    /**
     * Creates a {@link Wrapper} with the specified list.
     * @param items the list of items to wrap.
     */
    public Wrapper(List<T> items) {
        this.items = items;
    }
 
    /**
     * Returns the wrapped items.
     * @return the wrapped items.
     */
    @XmlAnyElement(lax=true)
    public List<T> getItems() {
        return items;
    }
}
