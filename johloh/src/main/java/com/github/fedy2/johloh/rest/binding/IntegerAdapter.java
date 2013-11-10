/**
 *
 */
package com.github.fedy2.johloh.rest.binding;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import java.text.NumberFormat;

/**
 * An {@link XmlAdapter} for the {@link Integer} type. This adapter support int number represented with US locale.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
public class IntegerAdapter extends XmlAdapter<String, Integer> {
	
	protected NumberFormat numberFormat = NumberFormat.getNumberInstance(java.util.Locale.US); 

    /**
     * {@inheritDoc}
     */
    @Override
    public String marshal(Integer v) throws Exception {
        return numberFormat.format(v);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer unmarshal(String v) throws Exception {
    	if (v == null) return null;
        try {
            return numberFormat.parse(v).intValue();
        } catch (Exception e) {
        	throw new RuntimeException("Unknown integer format \""+v+"\"", e);
        }
    }

}
