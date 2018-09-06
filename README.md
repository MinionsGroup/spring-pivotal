# spring-pivotal

The main objective of the spring-pivotal project is create an API-REST with Spring-Framework.

## Getting Started

### Prerequisites

The required configuration for this project is the following:

    -Java JDK (jdk1.8.0_171).
    -IntelliJ idea IDE.
    -Download Gradle 3.5 or higher: https://gradle.org/gradle-download/
    -Clone/download the project from GitHub repository: https://github.com/MinionsGroup/spring-pivotal.git

### Installing

To-do

## Running tests

To-do

## Deployment

Set the required parameters to application.properties:

    -server.address: Your server address example(192.168.1.47).
    -server.port: Your server port example(8080).

After that you should execute: src/main/java/org/pivotal/Application.java.

## End Points

### Projects End Points
    -GET: http://localhost:8080/api/v1/projects/
    -GET: http://localhost:8080/api/v1/projects/{id}
    -POST: http://localhost:8080/api/v1/projects/
    -    {
    -        "id": "1",
    -        "name": "project1"
    -    }
    -PUT : http://localhost:8080/api/v1/projects/{id}
    -    {
    -        "id": "1",
    -        "name": "project1"
    -    }
    -DELETE: http://localhost:8080/api/v1/projects/{id}

## Contributing

Current contributors:

    -Abel Barrientos (Sphinix27) - https://github.com/Sphinix27
    -Richard Severiche (RichardSeverich) - https://github.com/RichardSeverich
    -Daniel Montecinos (daniel-m10) - https://github.com/daniel-m10
