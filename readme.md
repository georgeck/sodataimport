```bash
mvn compile exec:java -Dexec.mainClass="application" -Dexec.args="../data/Users.xml localhost "
```

## CQL Schema

```
CREATE KEYSPACE stackoverflow_com WITH replication = {'class': 'NetworkTopologyStrategy', 'dc0': '3'}  AND durable_writes = true;

CREATE TABLE stackoverflow_com.user_counter (
    id int PRIMARY KEY,
    downvotes counter,
    upvotes counter,
    views counter
);

CREATE TABLE stackoverflow_com.user (
    id int PRIMARY KEY,
    aboutme text,
    accountid int,
    age int,
    creationdate timestamp,
    displayname text,
    emailhash text,
    lastaccessdate timestamp,
    location text,
    profileimageurl text,
    reputation int,
    websiteurl text
) ;
```
  
