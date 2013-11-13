johloh
======

A Java API for Ohloh.

Dependency declaration:

    <dependency>
      <groupId>com.github.fedy2</groupId>
      <artifactId>johloh</artifactId>
      <version>1.0.1</version>
    </dependency>

##Usage

Retrieve an account:

    OhlohClient client = new OhlohClient("YOUR API KEY");
    Account account = client.getAccount("113399");
    System.out.println(account.getName());


Retrieve all the accounts containing the word "Alex" in the name:

    OhlohClient client = new OhlohClient("YOUR API KEY");
    Query<Account> query = QueryBuilders.accountQuery().query("alex").build();
    Iterator<Account> accounts = client.getAccounts(query);
    while(accounts.hasNext()) System.out.println(accounts.next().getName());
    
    
Retrieve all the projects sorted by name:

    OhlohClient client = new OhlohClient("YOUR API KEY");
    Query<Project> query = QueryBuilders.projectQuery().sort(ProjectSort.NAME).build();
    Iterator<Project> projectIterator = client.getProjects(query);
    while(projectIterator.hasNext()) System.out.println(projectIterator.next().getName());
    
Changelog:

    * 1.0.1 fixed the groupId
    * 1.0.0 first release
