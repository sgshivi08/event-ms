# Event Microservice
API Documentation
Swagger documentation is available at http://localhost:8080/swagger-ui.html

## Overview

The Event Microservice is part of a larger event management system that allows users to create, manage, and search for events. This microservice provides RESTful APIs to handle event-related operations and interacts with other microservices for a complete event management experience.

## Technologies

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **H2 Database (In-Memory)**
- **SpringDoc OpenAPI (Swagger)**
- **JUnit 5 (JUnit Jupiter)**
- **Mockito**

## Setup

### Prerequisites

- Java 17
- Maven (for building the project)

### Clone the Repository

git clone https://github.com/sgshivi08/event-ms.git
cd event-microservice

Build the Project
mvn clean install

Run the Application
mvn spring-boot:run

The application will start on port 8080 by default.

Testing
To run unit tests, use:
mvn test


Exception Handling
The microservice uses Spring's @ControllerAdvice for centralized exception handling.

Configuration
Application Properties: Configure application settings in src/main/resources/application.properties.
