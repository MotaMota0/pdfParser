


#  Java - 21 onlyyy

---

### H2 - dataBase
### Spring Boot - 3.4.5
### Framework : Spring Boot 
### Dependecies :Spring Boot Jpa, Spring Boot JDBC, Library Apache.pdfbox, H2 DataBase,Thymeleaf

---

# ApacheTomcat server was run in 8084 port;

---

# Properties
- **application.properties**
spring.datasource.url=jdbc:h2:mem:testdb 
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true 
spring.jpa.hibernate.ddl-auto=update
 ---

run the application with command:

-** mvn spring-boot:run**
##   
Access the app at http://localhost:8084/.

---

## Database:
*H2 console is enabled at http://localhost:8080/h2-console (use JDBC URL jdbc:h2:mem:testdb, username sa, no password).

---
