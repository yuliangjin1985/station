# Project report
This is a demo project using technologies RESTful, Spring Boot, MyBatis, H2, actuator
## api
### Swagger UI
http://localhost:8080/swagger-ui.html
### Actuator
 + http://localhost:8081/actuator/health
 + http://localhost:8081/actuator/info
## Test
### Unit test
For unit test, I practiced TDD, developing unit test cases for controller before the actual controller development. I mainly used `@WebMvcTest` and Mockito to mock the dependency on Service.
### Integration test
I used `@SpringBootTest` and `TestRestTemplate` to start the requests for every api and then verify the response.
### Jacoco
 + Total coverage
 + Controller coverage
 + Service coverage