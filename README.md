johloh
======

A Java API for Ohloh.

Will be soon available in maven central.

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
