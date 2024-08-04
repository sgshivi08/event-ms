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

```bash
git clone https://github.com/your-repo/event-microservice.git
cd event-microservice

Build the Project
mvn clean install

Run the Application
mvn spring-boot:run


The application will start on port 8080 by default.

API Endpoints
Create an Event
URL: /events
Method: POST
Request Body:
{
    "eventName": "Sample Event",
    "eventDate": "2024-08-04",
    "eventTime": "14:00",
    "eventLocation": "Sample Location",
    "availableTickets": 100
}

{
    "id": 1,
    "eventName": "Sample Event",
    "eventDate": "2024-08-04",
    "eventTime": "14:00",
    "eventLocation": "Sample Location",
    "availableTickets": 100
}
Get Event by ID
URL: /events/{id}
Method: GET
Response:

{
    "id": 1,
    "eventName": "Sample Event",
    "eventDate": "2024-08-04",
    "eventTime": "14:00",
    "eventLocation": "Sample Location",
    "availableTickets": 100
}

Update an Event
URL: /events/{id}
Method: PUT
Request Body:
{
    "eventName": "Updated Event",
    "eventDate": "2024-08-05",
    "eventTime": "16:00",
    "eventLocation": "Updated Location",
    "availableTickets": 150
}

{
    "id": 1,
    "eventName": "Updated Event",
    "eventDate": "2024-08-05",
    "eventTime": "16:00",
    "eventLocation": "Updated Location",
    "availableTickets": 150
}
Delete an Event
URL: /events/{id}
Method: DELETE
Response: 204 No Content
Check Availability
URL: /events/{id}/availability
Method: GET
Response:
{
    "availableTickets": 100
}


Testing
To run unit tests, use:
mvn test


Exception Handling
The microservice uses Spring's @ControllerAdvice for centralized exception handling.

Configuration
Application Properties: Configure application settings in src/main/resources/application.properties.
