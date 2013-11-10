/**
 * 
 */
package com.github.fedy2.johloh;

import java.net.Proxy;
import java.util.Iterator;

import com.github.fedy2.johloh.query.Query;
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
import com.github.fedy2.johloh.rest.RequestUrl;
import com.github.fedy2.johloh.rest.RequestUrlBuilder;
import com.github.fedy2.johloh.rest.RestClient;
import com.github.fedy2.johloh.rest.data.Response;
import com.github.fedy2.johloh.rest.http.DefaultHttpClient;
import com.github.fedy2.johloh.rest.paging.ItemIterator;
import com.github.fedy2.johloh.rest.paging.PageIterator;

/**
 * The Ohloh service client.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
public class OhlohClient {
	
	protected static final String STACKS = "stacks";
	protected static final String LATEST = "latest";
	protected static final String LANGUAGES = "languages";
	protected static final String FACTOIDS = "factoids";
	protected static final String ENLISTMENTS = "enlistments";
	protected static final String CONTRIBUTORS = "contributors";
	protected static final String ANALYSES = "analyses";
	protected static final String ACCOUNTS = "accounts";
	protected static final String PROJECTS = "projects";
	
	protected RestClient restClient;
	
	/**
	 * Creates a new instance of {@link OhlohClient} using the specified API key.
	 * @param apiKey the API key to use.
	 */
	public OhlohClient(String apiKey)
	{
		restClient = new RestClient("http", "www.ohloh.net");
		restClient.addDefaultParameter("api_key", apiKey);
	}
	
	/**
	 * Creates a new instance of {@link OhlohClient} using the specified API key.
	 * @param apiKey the API key to use.
	 * @param proxy the {@link Proxy} to use for service connections.
	 */
	public OhlohClient(String apiKey, Proxy proxy)
	{
		restClient = new RestClient("http", "www.ohloh.net", new DefaultHttpClient(proxy));
		restClient.addDefaultParameter("api_key", apiKey);
	}
	
	/**
	 * Gets the {@link Account} with the specified id.
	 * @param id the account id.
	 * @return the retrieved account.
	 */
	public Account getAccount(String id) {
		RequestUrl url = restClient.getRequestUrlBuilder().path(ACCOUNTS).path(id+".xml").build();
		Response<Account> response = makeRequest(url);
		return response.getResult();
	}
	
	/**
	 * Gets the {@link Account} with the specified email MD5 hash.
	 * @param emailHash the account email MD5 hash.
	 * @return the retrieved account.
	 */
	public Account getAccountByEmail(String emailHash) {
		RequestUrl url = restClient.getRequestUrlBuilder().path(ACCOUNTS).path(emailHash+".xml").build();
		Response<Account> response = makeRequest(url);
		return response.getResult();
	}
	
	/**
	 * Gets all the available {@link Account}s.
	 * @return an {@link Iterator} over the fetched {@link Account}s.
	 */
	public Iterator<Account> getAccounts()
	{
		return getAccounts(Query.<Account>emptyQuery());
	}
	
	/**
	 * Gets all the {@link Account}s filtered by the query parameters.
	 * @param query the request parameters.
	 * @return an {@link Iterator} over the fetched {@link Account}s.
	 */
	public Iterator<Account> getAccounts(Query<Account> query) {
		RequestUrlBuilder builder = restClient.getRequestUrlBuilder().path("accounts.xml").parameters(query.toParameters());
		return buildIterator(builder);
	}
	
	/**
	 * Gets all the {@link ActivityFact}s for the specified {@link Project} id and {@link Analysis} id.
	 * @param projectId the {@link Project} id.
	 * @param analysisId the {@link Analysis} id.
	 * @return the retrieved activity facts.
	 */
	public Iterator<ActivityFact> getActivityFacts(String projectId, String analysisId) {
		RequestUrlBuilder builder = restClient.getRequestUrlBuilder().path(PROJECTS).path(projectId).path(ANALYSES).path(analysisId).path("activity_facts.xml");
		return buildIterator(builder);
	}
	
	/**
	 * Gets the last {@link Analysis} {@link ActivityFact}s for the specified {@link Project} id. 
	 * @param projectId the {@link Project} id.
	 * @return the retrieved activity facts.
	 */
	public Iterator<ActivityFact> getLatestActivityFacts(String projectId) {
		return getActivityFacts(projectId, LATEST);
	}
	
	/**
	 * Gets the specified {@link Analysis} for the specified {@link Project}.
	 * @param projectId the {@link Project} id.
	 * @param analysisId the {@link Analysis} id.
	 * @return the retrieved analysis.
	 */
	public Analysis getAnalysis(String projectId, String analysisId) {
		RequestUrl url = restClient.getRequestUrlBuilder().path(PROJECTS).path(projectId).path(ANALYSES).path(analysisId+".xml").build();
		Response<Analysis> response = makeRequest(url);
		return response.getResult();
	}
	
	/**
	 * Gets the last {@link Analysis} for the specified {@link Project}.
	 * @param projectId the {@link Project} id.
	 * @return the retrieved analysis.
	 */
	public Analysis getLatestAnalysis(String projectId) {
		return getAnalysis(projectId, LATEST);
	}
	
	public ContributorFact getContributorFact(String projectId, String contributorId) {
		RequestUrl url = restClient.getRequestUrlBuilder().path(PROJECTS).path(projectId).path(CONTRIBUTORS).path(contributorId+".xml").build();
		Response<ContributorFact> response = makeRequest(url);
		return response.getResult();
	}
	
	/**
	 * Gets all the {@link ContributorFact}s for the specified {@link Project} id.
	 * @param projectId the {@link Project} id.
	 * @return the retrieved contributor facts.
	 */
	public Iterator<ContributorFact> getContributorFacts(String projectId) {
		return getContributorFacts(projectId, Query.<ContributorFact>emptyQuery());
	}
	
	/**
	 * Gets the {@link ContributorFact}s for the specified {@link Project} id and with the specified {@link Query} parameters.
	 * @param projectId the {@link Project} id.
	 * @param query the {@link Query} to apply.
	 * @return the retrieved contributor facts.
	 */
	public Iterator<ContributorFact> getContributorFacts(String projectId, Query<ContributorFact> query) {
		RequestUrlBuilder builder = restClient.getRequestUrlBuilder().path(PROJECTS).path(projectId).path(CONTRIBUTORS+".xml").parameters(query.toParameters());
		return buildIterator(builder);
	}
	
	/**
	 * Gets the {@link Enlistment} for the specified id and {@link Project} id.
	 * @param projectId the project id.
	 * @param enlistmentId the enlistment id.
	 * @return the retrieved enlistment.
	 */
	public Enlistment getEnlistment(String projectId, String enlistmentId) {
		RequestUrl url = restClient.getRequestUrlBuilder().path(PROJECTS).path(projectId).path(ENLISTMENTS).path(enlistmentId+".xml").build();
		Response<Enlistment> response = makeRequest(url);
		return response.getResult();
	}
	
	/**
	 * Gets all the {@link Enlistment}s for the specified {@link Project}.
	 * @param projectId the project id.
	 * @return the retrieved enlistment.
	 */
	public Iterator<Enlistment> getEnlistments(String projectId) {
		return getEnlistments(projectId, Query.<Enlistment>emptyQuery());
	}
	
	/**
	 * Gets all the {@link Enlistment}s for the specified {@link Project} id and with the applied query.
	 * @param projectId the project id.
	 * @param query the query to apply.
	 * @return the retrieved enlistment.
	 */
	public Iterator<Enlistment> getEnlistments(String projectId, Query<Enlistment> query) {
		RequestUrlBuilder builder = restClient.getRequestUrlBuilder().path(PROJECTS).path(projectId).path(ENLISTMENTS+".xml").parameters(query.toParameters());
		return buildIterator(builder);
	}
	
	/**
	 * Gets the {@link Factoid} for the specified id and {@link Project} id. 
	 * @param projectId the project id.
	 * @param factoidId the factoid id.
	 * @return the retrieved factoid.
	 */
	public Factoid getFactoid(String projectId, String factoidId) {
		RequestUrl url = restClient.getRequestUrlBuilder().path(PROJECTS).path(projectId).path(FACTOIDS).path(factoidId+".xml").build();
		Response<Factoid> response = makeRequest(url);
		return response.getResult();
	}
	
	/**
	 * Gets all the {@link Factoid}s for the specified {@link Project}.
	 * @param projectId the project id.
	 * @return the retrieved factoids.
	 */
	public Iterator<Factoid> getFactoids(String projectId) {
		return getFactoids(projectId, Query.<Factoid>emptyQuery());
	}
	
	/**
	 * Gets all the {@link Factoid}s for the specified {@link Project} and with specified {@link Query}.
	 * @param projectId the project id.
	 * @param query the query to apply.
	 * @return the retrieved factoids.
	 */
	public Iterator<Factoid> getFactoids(String projectId, Query<Factoid> query) {
		RequestUrlBuilder builder = restClient.getRequestUrlBuilder().path(PROJECTS).path(projectId).path(FACTOIDS+".xml").parameters(query.toParameters());
		return buildIterator(builder);
	}
	
	/**
	 * Gets all the {@link Kudo}s for the specified {@link Account}.
	 * @param accountId the account id.
	 * @return the retrieved kudos.
	 */
	public Iterator<Kudo> getKudos(String accountId) {
		RequestUrlBuilder builder = restClient.getRequestUrlBuilder().path(ACCOUNTS).path(accountId).path("kudos.xml");
		return buildIterator(builder);
	}
	
	/**
	 * Gets all the sent {@link Kudo} for the specified {@link Account}.
	 * @param accountId the account id.
	 * @return the retrieved kudos.
	 */
	public Iterator<Kudo> getSentKudos(String accountId) {
		RequestUrlBuilder builder = restClient.getRequestUrlBuilder().path(ACCOUNTS).path(accountId).path("kudos").path("sent.xml");
		return buildIterator(builder);
	}
	
	/**
	 * Gets the specified {@link Language}.
	 * @param id the language id.
	 * @return the retrieved language.
	 */
	public Language getLanguage(String id)
	{
		RequestUrl url = restClient.getRequestUrlBuilder().path(LANGUAGES).path(id+".xml").build();
		Response<Language> response = makeRequest(url);
		return response.getResult();
	}
	
	/**
	 * Gets all the {@link Language}s.
	 * @return the retrieved languages.
	 */
	public Iterator<Language> getLanguages()
	{
		return getLanguages(Query.<Language>emptyQuery());
	}
	
	/**
	 * Gets the {@link Language}s for the specified {@link Query}.
	 * @param query the query to apply.
	 * @return the retrieved languages.
	 */
	public Iterator<Language> getLanguages(Query<Language> query)
	{
		RequestUrlBuilder builder = restClient.getRequestUrlBuilder().path(LANGUAGES+".xml").parameters(query.toParameters());
		return buildIterator(builder);
	}
	
	/**
	 * Gets all the {@link Position} for the specified {@link Account}.
	 * @param accountId the account id.
	 * @return the retrieved positions.
	 */
	public Iterator<Position> getPositions(String accountId) {
		RequestUrlBuilder builder = restClient.getRequestUrlBuilder().path(ACCOUNTS).path(accountId).path("position.xml");
		return buildIterator(builder);
	}
	
	/**
	 * Gets the specified {@link Project}.
	 * @param id the project id.
	 * @return the retrieved project.
	 */
	public Project getProject(String id)
	{
		RequestUrl url = restClient.getRequestUrlBuilder().path(PROJECTS).path(id+".xml").build();
		Response<Project> response = makeRequest(url);
		return response.getResult();
	}
	
	/**
	 * Gets all the {@link Project}s.
	 * @return the retrieved projects.
	 */
	public Iterator<Project> getProjects()
	{
		return getProjects(Query.<Project>emptyQuery());
	}
	
	/**
	 * Gets all the {@link Project}s for the specified {@link Query}.
	 * @param query the {@link Query} to apply.
	 * @return the retrieved projects.
	 */
	public Iterator<Project> getProjects(Query<Project> query)
	{
		RequestUrlBuilder builder = restClient.getRequestUrlBuilder().path("projects.xml").parameters(query.toParameters());
		return buildIterator(builder);
	}
	
	/**
	 * Gets the {@link SizeFact}s for the specified project and analysis.
	 * @param projectId the {@link Project} id.
	 * @param analysisId the {@link Analysis} id.
	 * @return the retrieved size facts.
	 */
	public Iterator<SizeFact> getSizeFacts(String projectId, String analysisId) {
		RequestUrlBuilder builder = restClient.getRequestUrlBuilder().path(PROJECTS).path(projectId).path(ANALYSES).path(analysisId).path("size_facts.xml");
		return buildIterator(builder);
	}
	
	/**
	 * Gets the latest {@link SizeFact}s from the specified {@link Project} id.
	 * @param projectId the project id.
	 * @return the retrieved size facts.
	 */
	public Iterator<SizeFact> getLatestSizeFacts(String projectId) {
		return getSizeFacts(projectId, LATEST);
	}
	
	/**
	 * Gets the {@link Stack} with the specified id and {@link Account} id.
	 * @param accountId the account id.
	 * @param stackId the stack id.
	 * @return the retrieved stack.
	 */
	public Stack getStack(String accountId, String stackId)
	{
		RequestUrl url = restClient.getRequestUrlBuilder().path(ACCOUNTS).path(accountId).path(STACKS).path(stackId+".xml").build();
		Response<Stack> response = makeRequest(url);
		return response.getResult();
	}
	
	/**
	 * Gets the default {@link Stack} for the specified {@link Account} id.
	 * @param accountId the account id.
	 * @return the retrieved {@link Stack}.
	 */
	public Stack getDefaultStack(String accountId)
	{
		return getStack(accountId, "default");
	}
	
	/**
	 * Gets all the {@link Stack}s for the specified {@link Project} id.
	 * @param projectId the {@link Project} id.
	 * @return the retrieved stacks.
	 */
	public Iterator<Stack> getStacks(String projectId)
	{
		return getStacks(projectId, Query.<Stack>emptyQuery());
	}
	
	/**
	 * Gets the {@link Stack}s for the specified {@link Project} id and with the specified {@link Query} parameters.
	 * @param projectId the {@link Project} id.
	 * @param query the {@link Query}.
	 * @return the retrieved stacks.
	 */
	public Iterator<Stack> getStacks(String projectId, Query<Stack> query)
	{
		RequestUrlBuilder builder = restClient.getRequestUrlBuilder().path(PROJECTS).path(projectId).path(STACKS+".xml").parameters(query.toParameters());
		return buildIterator(builder);
	}
	
	/**
	 * Makes a request to the REST client.
	 * @param url the {@link RequestUrl}.
	 * @return the REST response.
	 */
	protected <T> Response<T> makeRequest(RequestUrl url) {
		Response<T> response = restClient.request(url);
		if ("failed".equals(response.getStatus())) throw new RuntimeException("Request failed: "+response.getError());
		return response;
	}
	
	/**
	 * Builds an iterator from the specified {@link RequestUrlBuilder}.
	 * @param builder the request url builder.
	 * @return the elements iterator.
	 */
	protected <T> Iterator<T> buildIterator(RequestUrlBuilder builder) {
		PageIterator<T> pageIterator = new PageIterator<>(builder, restClient);
		return new ItemIterator<>(pageIterator);
	}
}
