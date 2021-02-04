*******If you want to access the external properties file
# -Dspring.config.location = C:\application.properties

*******If you want to set spring profile using .properties
then you can create .properties file in such ways like
# for dev --> application-dev.properties
# for prod --> application-prod.properties

# java -jar spring-boot.jar --spring.profiles.active=prod --> spring will automatically use application-prod.properties

*******But in .yml file we dont need to create lot of environment specific files --> application.yml
# for segregation we can use "---"
spring:
   application:
      name: demoservice
server:
   port: 8080

---
spring:
   profiles: dev
   application:
      name: demoservice
server:
   port: 9090

---
spring: 
   profiles: prod
   application:
      name: demoservice
server: 
   port: 4431
   
   
*******