# HTTP Server

- [HTTP Server](#http-server)
  - [General info](#general-info)
  - [Setup server](#setup-server)
    - [Using Maven](#using-maven)
    - [Using IntelliJ](#using-intellij)
  - [Sending request](#sending-request)
    - [Using WebBrowser](#using-webbrowser)
    - [Using Postman](#using-postman)
  - [Requests](#requests)
    - [Return every repository of selected user](#return-every-repository-of-selected-user)
    - [Return sum of stars in all repositories of selected user](#return-sum-of-stars-in-all-repositories-of-selected-user)
  - [Techonologies](#techonologies)
  - [Limits](#limits)

## General info
>Stwórz oprogramowanie pozwalające na:
>- listowanie repozytoriów (nazwa i liczba gwiazdek),
>- zwracanie sumy gwiazdek we wszystkich repozytoriach, dla dowolnego użytkownika serwisu GitHub.  
>
>Dane powinny być zwracane za pomocą protokołu HTTP.

The implementation of basic server using REST with Spring. To get information, I've used [GithubApi](https://api.github.com/)
Request return:
- list of every repository of selected user
- sum of stars in all repositories of selected user

Returned data is in JSON format.
## Setup server
### Using Maven
   1. Open cmd in Project file
   2. `mvn compile`
   3. `mvn spring-boot:run`
### Using IntelliJ
   1. Open project via IntellJ IDEA
   2. Click Run button
## Sending request
### Using WebBrowser
Enter request ro the adress bar
### Using Postman
Import [allegro_api.postman_collection.json](allegro_api.postman_collection.json) and choose one of the implemented requests
## Requests
>default localhost is usually 127.0.0.1. Check your configuration.
### Return every repository of selected user
>http://localhost:8080/find/{username}
### Return sum of stars in all repositories of selected user
>http://localhost:8080/stars/{username}
## Techonologies
| Name | Version |
| ------ | ------ |
| Apache Maven | 3.6.3 |
| IntelliJ IDEA (Ultimate Edition) | 2021.1 |
| SDK | corretto-11 |
| OS | Windows 10 |
| Spring | 2.4.5 |   
## Limits
- Maximum amount of returned informations about repositories is 100. To get every repository of given user with pver 100 repositories, do couple iterations
- Github API allows to do 60 request per hour, that means you can get valid response, when user have maximum 6000 repositories