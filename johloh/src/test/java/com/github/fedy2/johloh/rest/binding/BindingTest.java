/**
 * 
 */
package com.github.fedy2.johloh.rest.binding;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static com.github.fedy2.johloh.rest.binding.TestUtil.*;
import static org.junit.Assert.*;
import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;

import java.io.IOException;
import java.net.URL;

import org.custommonkey.xmlunit.XMLUnit;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

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
import com.github.fedy2.johloh.rest.RestClient;
import com.github.fedy2.johloh.rest.binding.DefaultBinder;
import com.github.fedy2.johloh.rest.data.Response;
import com.github.fedy2.johloh.rest.http.HttpClient;


/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class BindingTest {
	
	protected static RestClient restClient;
	
	protected static URL ACCOUNT_URL;
	protected static String ACCOUNT_RESOURCE;
	
	protected static URL ANALYSIS_URL;
	protected static String ANALYSIS_RESOURCE;
	
	protected static URL CONTRIBUTORFACT_URL;
	protected static String CONTRIBUTORFACT_RESOURCE;
	
	protected static URL ENLISTMENT_URL;
	protected static String ENLISTMENT_RESOURCE;
	
	protected static URL FACTOID_URL;
	protected static String FACTOID_RESOURCE;
	
	protected static URL KUDO_URL;
	protected static String KUDO_RESOURCE;
	
	protected static URL LANGUAGE_URL;
	protected static String LANGUAGE_RESOURCE;
	
	protected static URL POSITION_URL;
	protected static String POSITION_RESOURCE;
	
	protected static URL PROJECT_URL;
	protected static String PROJECT_RESOURCE;
	
	protected static URL ACTIVITYFACT_URL;
	protected static String ACTIVITYFACT_RESOURCE;
	
	protected static URL SIZEFACT_URL;
	protected static String SIZEFACT_RESOURCE;
	
	protected static URL STACK_URL;
	protected static String STACK_RESOURCE;

	protected static DefaultBinder parser;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		XMLUnit.setIgnoreWhitespace(true);
		
		HttpClient client = mock(HttpClient.class);
		
		ACCOUNT_RESOURCE = getResource("binding/account.xml");
		ACCOUNT_URL = new URL("http://www.ohloh.net/accounts/amujumdar.xml");
		when(client.get(ACCOUNT_URL)).thenReturn(ACCOUNT_RESOURCE);
		
		ACTIVITYFACT_RESOURCE = getResource("binding/activityfacts.xml");
		ACTIVITYFACT_URL = new URL("http://www.ohloh.net/projects/ohloh_scm/analyses/latest/activity_facts.xml");
		when(client.get(ACTIVITYFACT_URL)).thenReturn(ACTIVITYFACT_RESOURCE);
		
		ANALYSIS_RESOURCE = getResource("binding/analysis.xml");
		ANALYSIS_URL = new URL("http://www.ohloh.net/projects/ohloh_scm/analyses/latest.xml");
		when(client.get(ANALYSIS_URL)).thenReturn(ANALYSIS_RESOURCE);
		
		CONTRIBUTORFACT_RESOURCE = getResource("binding/contributorFact.xml");
		CONTRIBUTORFACT_URL = new URL("http://www.ohloh.net/projects/ohloh_scm/contributors/amujumdar.xml");
		when(client.get(CONTRIBUTORFACT_URL)).thenReturn(CONTRIBUTORFACT_RESOURCE);
		
		ENLISTMENT_RESOURCE = getResource("binding/enlistment.xml");
		ENLISTMENT_URL = new URL("http://www.ohloh.net/projects/ohloh_scm/enlistments/460085.xml");
		when(client.get(ENLISTMENT_URL)).thenReturn(ENLISTMENT_RESOURCE);
		
		FACTOID_RESOURCE = getResource("binding/factoid.xml");
		FACTOID_URL = new URL("http://www.ohloh.net/projects/ohloh_scm/factoids/460085.xml");
		when(client.get(FACTOID_URL)).thenReturn(FACTOID_RESOURCE);
		
		KUDO_RESOURCE = getResource("binding/kudos.xml");
		KUDO_URL = new URL("http://www.ohloh.net/account/amujumdar/kudos.xml");
		when(client.get(KUDO_URL)).thenReturn(KUDO_RESOURCE);
		
		LANGUAGE_RESOURCE = getResource("binding/language.xml");
		LANGUAGE_URL = new URL("http://www.ohloh.net/languages/java.xml");
		when(client.get(LANGUAGE_URL)).thenReturn(LANGUAGE_RESOURCE);
		
		POSITION_RESOURCE = getResource("binding/positions.xml");
		POSITION_URL = new URL("http://www.ohloh.net/accounts/amujumdar/positions.xml");
		when(client.get(POSITION_URL)).thenReturn(POSITION_RESOURCE);
		
		PROJECT_RESOURCE = getResource("binding/project.xml");
		PROJECT_URL = new URL("http://www.ohloh.net/projects/ohloh_scm.xml");
		when(client.get(PROJECT_URL)).thenReturn(PROJECT_RESOURCE);
		
		SIZEFACT_RESOURCE = getResource("binding/sizefacts.xml");
		SIZEFACT_URL = new URL("http://www.ohloh.net/projects/ohloh_scm/analyses/latest/size_facts.xml");
		when(client.get(SIZEFACT_URL)).thenReturn(SIZEFACT_RESOURCE);
		
		STACK_RESOURCE = getResource("binding/stack.xml");
		STACK_URL = new URL("http://www.ohloh.net/accounts/amujumdar/stacks/default.xml");
		when(client.get(STACK_URL)).thenReturn(STACK_RESOURCE);
		
		parser = new DefaultBinder();
		restClient = new RestClient("http", "www.ohloh.net", client, parser);
	}
	
	@Test
	public void testAccountBinding() throws SAXException, IOException
	{
		Response<Account> response = restClient.request(ACCOUNT_URL);
		
		assertNotNull(response);
		assertNotNull(response.getResult());
		assertNotNull(response.getResult().getId());
		
		String xml = parser.compose(response);
		assertXMLEqual(ACCOUNT_RESOURCE, xml);
	}
	
	@Test
	public void testActivityFactBinding() throws SAXException, IOException
	{
		Response<ActivityFact> response = restClient.request(ACTIVITYFACT_URL);
				
		assertNotNull(response);
		assertNotNull(response.getResult());
		assertNotNull(response.getResult().getCodeAdded());
		
		String xml = parser.compose(response);
		assertXMLEqual(ACTIVITYFACT_RESOURCE, xml);
	}
	
	@Test
	public void testAnalysisBinding() throws SAXException, IOException
	{
		Response<Analysis> response = restClient.request(ANALYSIS_URL);
				
		assertNotNull(response);
		assertNotNull(response.getResult());
		assertNotNull(response.getResult().getId());
		
		String xml = parser.compose(response);
		assertXMLEqual(ANALYSIS_RESOURCE, xml);
	}
	
	@Test
	public void testContributorFactBinding() throws SAXException, IOException
	{
		Response<ContributorFact> response = restClient.request(CONTRIBUTORFACT_URL);
				
		assertNotNull(response);
		assertNotNull(response.getResult());
		assertNotNull(response.getResult().getAccountId());
		
		String xml = parser.compose(response);
		assertXMLEqual(CONTRIBUTORFACT_RESOURCE, xml);
	}
	
	@Test
	public void testEnlistmentBinding() throws SAXException, IOException
	{
		Response<Enlistment> response = restClient.request(ENLISTMENT_URL);
				
		assertNotNull(response);
		assertNotNull(response.getResult());
		assertNotNull(response.getResult().getId());
		
		String xml = parser.compose(response);
		assertXMLEqual(ENLISTMENT_RESOURCE, xml);
	}
	
	@Test
	public void testFactoidBinding() throws SAXException, IOException
	{
		Response<Factoid> response = restClient.request(FACTOID_URL);
				
		assertNotNull(response);
		assertNotNull(response.getResult());
		assertNotNull(response.getResult().getId());
		
		String xml = parser.compose(response);
		assertXMLEqual(FACTOID_RESOURCE, xml);
	}
	
	@Test
	public void testKudoBinding() throws SAXException, IOException
	{
		Response<Kudo> response = restClient.request(KUDO_URL);
				
		assertNotNull(response);
		assertNotNull(response.getResult());
		assertNotNull(response.getResult().getSenderAccountId());
		
		String xml = parser.compose(response);
		assertXMLEqual(KUDO_RESOURCE, xml);
	}
	
	@Test
	public void testLanguageBinding() throws SAXException, IOException
	{
		Response<Language> response = restClient.request(LANGUAGE_URL);
				
		assertNotNull(response);
		assertNotNull(response.getResult());
		assertNotNull(response.getResult().getId());
		
		String xml = parser.compose(response);
		assertXMLEqual(LANGUAGE_RESOURCE, xml);
	}
	
	@Test
	public void testPositionBinding() throws SAXException, IOException
	{
		Response<Position> response = restClient.request(POSITION_URL);
				
		assertNotNull(response);
		assertNotNull(response.getResult());
		assertNotNull(response.getResult().getTitle());
		
		String xml = parser.compose(response);
		assertXMLEqual(POSITION_RESOURCE, xml);
	}
	
	@Test
	public void testProjectBinding() throws SAXException, IOException
	{
		Response<Project> response = restClient.request(PROJECT_URL);
				
		assertNotNull(response);
		assertNotNull(response.getResult());
		assertNotNull(response.getResult().getId());
		
		String xml = parser.compose(response);
		assertXMLEqual(PROJECT_RESOURCE, xml);
	}
	
	@Test
	public void testSizeFactBinding() throws SAXException, IOException
	{
		Response<SizeFact> response = restClient.request(SIZEFACT_URL);
				
		assertNotNull(response);
		assertNotNull(response.getResult());
		assertNotNull(response.getResult().getBlanks());
		
		String xml = parser.compose(response);
		assertXMLEqual(SIZEFACT_RESOURCE, xml);
	}
	
	@Test
	public void testStackBinding() throws SAXException, IOException
	{
		Response<Stack> response = restClient.request(STACK_URL);
				
		assertNotNull(response);
		assertNotNull(response.getResult());
		assertNotNull(response.getResult().getAccountId());
		
		String xml = parser.compose(response);
		assertXMLEqual(STACK_RESOURCE, xml);
	}

}
