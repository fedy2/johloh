
package com.github.fedy2.johloh.resource;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.github.fedy2.johloh.rest.binding.RepositoryTypeAdapter;


/**
 * The source control type. Supported values are:
 * 
 */
@XmlJavaTypeAdapter(RepositoryTypeAdapter.class)
public enum RepositoryType {

	/**
	 * Subversion
	 */
	SVNREPOSITORY("SvnRepository"),
	
	/**
	 * CVS
	 */
	CVSREPOSITORY("CvsRepository"),
	
	/**
	 * Git
	 */
	GITREPOSITORY("GitRepository"),
	
	/**
	 * Mercurial
	 */
	HGREPOSITORY("HgRepository"),
	
	/**
	 * Bazaar
	 */
	BZRREPOSITORY("BzrRepository"),
	
	/**
	 * Subversion ‘svnsync’
	 */
	SVNSYNCREPOSITORY("SvnSyncRepository");
	
	static Map<String, RepositoryType> index;

    static
    {
    	index = new HashMap<>();
        for (RepositoryType type : RepositoryType.values()) index.put(type.getTypeName(), type);
    }
	
	private String typeName;

	/**
	 * @param typeName
	 */
	private RepositoryType(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}
	
	public static RepositoryType getType(String typeName)
	{
		return index.get(typeName);
	}
}
