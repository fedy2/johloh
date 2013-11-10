/**
 *
 */
package com.github.fedy2.johloh.rest.binding;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.github.fedy2.johloh.resource.FactoidType;

/**
 * An {@link XmlAdapter} for the {@link FactoidType} enumeration.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
public class FactoidTypeAdapter extends XmlAdapter<String, FactoidType> {

    /**
     * {@inheritDoc}
     */
    @Override
    public String marshal(FactoidType v) throws Exception {
        return v.getTypeName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FactoidType unmarshal(String v) throws Exception {
    	if (v == null) return null;
        try {
            return FactoidType.getType(v);
        } catch (Exception e) {
        	throw new RuntimeException("Unknown FactoidType \""+v+"\"", e);
        }
    }

}
