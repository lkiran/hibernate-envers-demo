# hibernate-envers-demo
 Demonstrates a basic usage of Spring Hibernate's Envers 
 
#### Dependencies
`hibernate-envers` is added for auditing, and `spring-data-envers` is added for querying repository.
```
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-envers</artifactId>
    <version>5.3.15.Final</version>
</dependency>
<dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-envers</artifactId>
    <version>2.2.4.RELEASE</version>
</dependency>
```

#### Implementations

+ `RepositoryConfiguration` class is created for using `RevisionRepository` with `JpaRepository`.

+ `Customer` domain class is created, and annotated with `@Audited` to enable hibernate-envers' auditing feature. 

+ `CustomerRepository` is extended by `RevisionRepository` in addition to standard `JpaRepository`. RevisionRepository allows fetching an entity's audit logs easily. [Documentation @ docs.spring.io ](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/history/RevisionRepository.html)

#### Endpoints

+ `GET` `/customer` returns existing customer list
+ `GET` `/customer/{id}` returns customer with specified id parameter
+ `GET` `/customer/{id}/audit` returns the audit history of customer with specified id parameter
+ `POST` `/customer` creates or updates (when _id_ is provided) customer object provided in request body
