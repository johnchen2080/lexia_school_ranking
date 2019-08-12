# Getting Started

1. start up the service with the following command line:

java -jar lexia_school_ranking-0.0.1-SNAPSHOT.jar schoolRankingServer 8080

2. After service started, open a browser and traverse the url:

http://localhost:8080/schoolranking/getSchoolRankings/2017

3. After seeing http response with 200 status. Got to the H2 db to check the tables:

http://localhost:8080/console
(login with JDBC-URL: jdbc:h2:mem:schoolranking-app
			User Name: SA 
)

# Please noted that the service is using a free service, therefore not all school and rankings are retrieved as expected.
# The following should be enough to demo the entire process of connecting to school digger API and save school and ranking to the db.

# Example API call to get school ranking list:
# https://api.schooldigger.com/v1.2/rankings/schools/MA?year=2019-2015&appID=a49f5fe5&appKey=4a7599f21913b07fbc9f9c491b4cf84c




### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [JDBC API](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-sql)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)


