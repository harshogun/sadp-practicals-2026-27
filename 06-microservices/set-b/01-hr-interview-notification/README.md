# HR Interview Notification Microservice

**Course:** M.Sc. Computer Science Part II — Software Architecture and Design Patterns  
**Assignment:** 6 — Microservices  
**Set:** B  
**Practical:** 1 — Send the candidate the message “You have been selected for an interview”

## Lab-book objective

Create an HR application as a microservice to send the message to the candidate: **“You have been selected for an interview”.**

## Technology Stack

- Java 25
- Spring Boot and Maven
- Spring Web REST API
- Jakarta Bean Validation
- Springdoc OpenAPI / Swagger UI
- In-memory notification storage

## Features

- Accept candidate name and email
- Validate candidate details
- Generate the exact interview-selection message required by the lab book
- Record notification details in memory
- List recorded notifications
- Explore and test endpoints with Swagger UI

## Important Demonstration Scope

This college practical generates and records a notification through a REST API. It does **not** deliver a real email or SMS because no mail server, SMS provider, or delivery integration is configured. Records are lost when the application restarts.

## Project Structure

```text
01-hr-interview-notification/
└── src/main/
    ├── java/com/harsh/hrnotification/
    │   ├── HrInterviewNotificationApplication.java
    │   ├── controller/HrNotificationController.java
    │   ├── dto/CandidateRequest.java
    │   ├── model/InterviewNotification.java
    │   └── service/NotificationService.java
    └── resources/application.properties
```

## Run the Application

From the repository root:

```bash
cd 06-microservices/set-b/01-hr-interview-notification
```

Run `HrInterviewNotificationApplication.java` in IntelliJ, or use Maven Wrapper.

**Windows PowerShell**
```powershell
.\mvnw.cmd spring-boot:run
```

**macOS/Linux**
```bash
./mvnw spring-boot:run
```

Configured port: `8081`.

## Swagger UI

- UI: http://localhost:8089/swagger-ui/index.html
- OpenAPI JSON: http://localhost:8089/v3/api-docs

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/hr/notifications/interview-selection` | Create an interview-selection notification |
| GET | `/api/hr/notifications` | List notifications recorded in memory |

## Sample Request

`POST /api/hr/notifications/interview-selection`

```json
{
  "candidateName": "Rahul More",
  "email": "rahul@example.com"
}
```

Expected status: `201 Created`.

The response contains the exact message:

```text
You have been selected for an interview
```

## Validation and Error Handling

- Candidate name is required and limited to 100 characters.
- Email is required and must be in valid email format.
- Invalid request data normally returns `400 Bad Request`.

## Architecture

Client / Swagger UI → `HrNotificationController` → `NotificationService` → in-memory notification map.

## Practical Outcome

A small, independently runnable Spring Boot service that accepts candidate details, generates the lab-book's interview-selection message, records the notification, and exposes REST endpoints for testing.
