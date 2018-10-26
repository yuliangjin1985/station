# Project report
This is a demo project using technologies RESTful, Spring Boot, MyBatis, H2, actuator
## api
All the apis could be checked and tested from the swagger UI page as follows:
 ![Total coverage][https://github.com/yuliangjin1985/station/blob/master/pics/apis-swagger.png]
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
 ![Total coverage][https://github.com/yuliangjin1985/station/blob/master/pics/total-coverage.png]
 + Controller coverage
 ![Controller coverage][https://github.com/yuliangjin1985/station/blob/master/pics/controller-coverage.png]
 + Service coverage
 ![Service coverage][https://github.com/yuliangjin1985/station/blob/master/pics/service-coverage.png]
