# Student Management Microservice

**Course:** M.Sc. Computer Science Part II — Software Architecture and Design Patterns  
**Assignment:** 6 — Microservices  
**Set:** A · **Practical:** 1

## Lab-book objective

Develop a module as a microservice to create a student management application using Spring Boot in Java. The lab book references Assignment 4, Q.3; that cross-reference appears inconsistent with the student-management objective, so this project follows the explicit objective.

## Technology Stack

- Java 25
- Spring Boot and Maven
- Spring Web REST API
- Jakarta Bean Validation
- Springdoc OpenAPI / Swagger UI
- In-memory storage using a concurrent map

## Features

- Create, list, retrieve, update, and delete students
- Validate name, email, course, and age
- Reject duplicate email addresses
- Interactive API documentation through Swagger UI

## Project Structure

```text
01-student-management-service/
└── src/main/
    ├── java/com/harsh/student/
    │   ├── StudentManagementApplication.java
    │   ├── controller/StudentController.java
    │   ├── dto/StudentRequest.java
    │   ├── model/Student.java
    │   └── service/StudentService.java
    └── resources/application.properties
```

## Run

From the repository root:

```bash
cd 06-microservices/set-a/01-student-management-service
```

Run `StudentManagementApplication.java` in IntelliJ, or use Maven Wrapper.

**Windows PowerShell**
```powershell
.\mvnw.cmd spring-boot:run
```

**macOS/Linux**
```bash
./mvnw spring-boot:run
```

Configured port: `8087`.

## Swagger UI

- UI: http://localhost:8087/swagger-ui/index.html
- OpenAPI JSON: http://localhost:8087/v3/api-docs

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/students` | List students |
| GET | `/api/students/{id}` | Get student by ID |
| POST | `/api/students` | Create student |
| PUT | `/api/students/{id}` | Update student |
| DELETE | `/api/students/{id}` | Delete student |

## Sample Request

`POST /api/students`

```json
{
  "name": "Rahul More",
  "email": "rahul@example.com",
  "course": "Computer Science",
  "age": 22
}
```

Expected response: `201 Created`.

## Validation and Error Handling

- Name, email, and course are required.
- Email must be valid.
- Age must be positive and at least 16 in this demonstration.
- Duplicate email returns `409 Conflict`.
- Missing student returns `404 Not Found`.
- Invalid request data normally returns `400 Bad Request`.

## Architecture

Client → StudentController → StudentService → In-memory storage.

The service is independently runnable and exposes an HTTP API, making it suitable as the first service in a microservices exercise. An API gateway is not included in this practical; the lab book addresses that in Set C.

## Limitations

Data is held in memory and resets when the application restarts. No database, authentication, service discovery, or API gateway is configured in this introductory service.

## Practical Outcome

A standalone Spring Boot student-management service with REST CRUD endpoints, validation, and Swagger UI.
