# Requirements

Installed JDK <em>suggested version 11</em> <br>
Installed Maven <em>suggested version 4.0.0</em> <br>
Environment set in the workstation for jdk/jre and maven <br>

# InventoryApp

Spring Boot version 2.3.3.RELEASE<br>
Project version not yet released.

The project contains the back-end of the website of natsuyami for his collections of codes, programs, application, etc.<br>
This project made to train for Spring Boot framework, OOP and Java coding structure, design pattern and features of the framework.<br>
Suggestion for improvement of the codebase is welcome.

## Documentation

Documentation of the project should be save and view here https://drive.google.com/file/d/1jlnrKkghFKDpz8gbsZJnsCoRrv9ub4m7/view?usp=sharing.

for api documentation (development) - http://localhost:8081/ni/swagger-ui.html

for api documentation (production) - tba
## Development

If workstation have eclipse, intellij or any IDE of your choice
then import the project and run it via maven configuration.<br>

Alternatively you can build, unit test and run using terminal:<br>
`build` and `test` - enter `mvn clean install` <br>
`build` without test - enter `mvn clean install -DskipTests` <br>
`run` - enter `mvn spring-boot:run` 

## Server
Production will be serve in heroku <br>

server health checker = `domain` + `/actuator` <em>details not yet complete<em> <br>
development - http://localhost:8081/ni <br>
production - tba


