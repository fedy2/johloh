/**
 *
 */
package com.github.fedy2.johloh.rest.binding;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.github.fedy2.johloh.resource.RepositoryType;

/**
 * An {@link XmlAdapter} for the enumeration {@link RepositoryType}.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
public class RepositoryTypeAdapter extends XmlAdapter<String, RepositoryType> {

    /**
     * {@inheritDoc}
     */
    @Override
    public String marshal(RepositoryType v) throws Exception {
        return v.getTypeName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryType unmarshal(String v) throws Exception {
    	if (v == null) return null;
        try {
            return RepositoryType.getType(v);
        } catch (Exception e) {
        	throw new RuntimeException("Unknown RepositoryType \""+v+"\"", e);
        }
    }

}
