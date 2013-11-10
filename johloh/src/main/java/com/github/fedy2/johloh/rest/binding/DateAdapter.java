/**
 *
 */
package com.github.fedy2.johloh.rest.binding;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * An {@link XmlAdapter} for the {@link Date} type.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
public class DateAdapter extends XmlAdapter<String, Date> {

    protected SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);

    /**
     * {@inheritDoc}
     */
    @Override
    public String marshal(Date v) throws Exception {
        return dateFormat.format(v);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date unmarshal(String v) throws Exception {
        try {
            return dateFormat.parse(v);
        } catch (Exception e) {
        	throw new RuntimeException("Unknown date format \""+v+"\"", e);
        }
    }

}
