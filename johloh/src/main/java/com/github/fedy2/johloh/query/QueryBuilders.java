/**
 * 
 */
package com.github.fedy2.johloh.query;

import com.github.fedy2.johloh.resource.Account;
import com.github.fedy2.johloh.resource.ContributorFact;
import com.github.fedy2.johloh.resource.Enlistment;
import com.github.fedy2.johloh.resource.Language;
import com.github.fedy2.johloh.resource.Project;
import com.github.fedy2.johloh.resource.Stack;

/**
 * An utility class for {@link QueryBuilder}.
 * @author "Federico De Faveri defaveri@gmail.com"
 */
public class QueryBuilders {
	
	public static class AccountQueryBuilder extends QueryBuilder<Account, AccountSort, AccountQueryBuilder> {
	}
	
	public static class ContributorFactQueryBuilder extends QueryBuilder<ContributorFact, ContributorFactSort, ContributorFactQueryBuilder> {
	}
	
	public static class EnlistmentQueryBuilder extends QueryBuilder<Enlistment, EnlistmentSort, EnlistmentQueryBuilder> {
	}
	
	public static class ProjectQueryBuilder extends QueryBuilder<Project, ProjectSort, ProjectQueryBuilder> {
	}
	
	public static class LanguageQueryBuilder extends QueryBuilder<Language, LanguageSort, LanguageQueryBuilder> {
	}
	
	public static class StackQueryBuilder extends QueryBuilder<Stack, StackSort, StackQueryBuilder> {
	}
	
	/**
	 * Starts building a {@link Project} query.
	 * @return the query builder.
	 */
	public static ProjectQueryBuilder projectQuery()
	{
		return new ProjectQueryBuilder();
	}
	
	/**
	 * Starts building a {@link Account} query.
	 * @return the query builder.
	 */
	public static AccountQueryBuilder accountQuery()
	{
		return new AccountQueryBuilder();
	}
	
	/**
	 * Starts building a {@link ContributorFact} query.
	 * @return the query builder.
	 */
	public static ContributorFactQueryBuilder contributorFactQuery()
	{
		return new ContributorFactQueryBuilder();
	}
	
	/**
	 * Starts building a {@link Enlistment} query.
	 * @return the query builder.
	 */
	public static EnlistmentQueryBuilder enlistmentQuery()
	{
		return new EnlistmentQueryBuilder();
	}
	
	/**
	 * Starts building a {@link Language} query.
	 * @return the query builder.
	 */
	public static LanguageQueryBuilder languageQuery()
	{
		return new LanguageQueryBuilder();
	}
	
	/**
	 * Starts building a {@link Stack} query.
	 * @return the query builder.
	 */
	public static StackQueryBuilder stackQuery()
	{
		return new StackQueryBuilder();
	}
}
