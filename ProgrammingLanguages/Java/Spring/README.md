## Spring

A popular Java framework.  

### [Spring and Maven](https://spring.io/guides/gs/maven/)

Create a simple Maven project. If you are unsure how to do that take a peek [here](https://github.com/MislavJaksic/Knowledge-Repository/tree/master/ProgrammingLanguages/Java/ProjectManagement/Maven).  
Take a look at the Spring Guides.  
Add plugins and dependencies depending on the project you want to create.  

### [Spring and Gradle](https://spring.io/guides/gs/gradle/)

TODO

### [Spring guides](https://spring.io/guides)

Spring has a lot of guides.  

#### [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)

Input: a HTTP request, using Postman for example  
Output: a requested representation, JSON for example  
Spring uses Jackson JSON to marshal/serialize data.  

Define a data structure, a bean.  
Construct a "controller", a REST API handler.  
Create a "application" executable, a runner class.  

The runner will start the program, the handler will send and receive HTTP requests.  

See Swagger for how you can automatically discover, print and interact with the Spring REST API.  

### [Swagger](https://swagger.io/)

REST API can be documented, discovered and displayed using Swagger.  

Add a Springfox and Swagger UI dependencies.  

Add a SwaggerConfig bean.  

Visit localhost:8080/swagger-ui.html.  