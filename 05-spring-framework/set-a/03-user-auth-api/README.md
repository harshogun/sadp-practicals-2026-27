# User Registration and Login API — Spring Boot

**Course:** M.Sc. Computer Science Part II — Software Architecture and Design Patterns (SADP)  
**Assignment:** 5 — Spring Framework  
**Set:** A  
**Practical:** 3 — User Registration and Login Module

## Objective

Develop a simple user registration and login module using Spring Boot and validate the user registration fields.

## Tech Stack

- Java 25
- Spring Boot
- Maven
- Spring Web
- Jakarta Bean Validation
- Spring Security Crypto (BCrypt password hashing)
- Springdoc OpenAPI / Swagger UI
- In-memory storage using `ConcurrentHashMap`

## Features

- Register users with name, email, and password
- Validate required fields and email format
- Require passwords between 8 and 72 characters
- Hash passwords using BCrypt before storing them
- Prevent duplicate email addresses (case-insensitive)
- Verify credentials during login
- Return safe user details without exposing passwords or password hashes
- Test endpoints interactively using Swagger UI

## Project Structure

```text
03-user-auth-api/
├── pom.xml
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── harsh/
        │           └── userauth/
        │               ├── UserAuthApplication.java
        │               ├── config/
        │               │   └── PasswordConfig.java
        │               ├── controller/
        │               │   └── AuthController.java
        │               ├── dto/
        │               │   ├── RegisterRequest.java
        │               │   ├── LoginRequest.java
        │               │   ├── UserResponse.java
        │               │   └── AuthResponse.java
        │               ├── model/
        │               │   └── UserAccount.java
        │               └── service/
        │                   └── AuthService.java
        └── resources/
            └── application.properties
```

## Prerequisites

- JDK 25
- IntelliJ IDEA or another Java IDE
- Maven (or Maven Wrapper)

## Run the Application

From the repository root:

```bash
cd 05-spring-framework/set-a/03-user-auth-api
```

Run `UserAuthApplication.java` from IntelliJ, or use the Maven Wrapper.

**Windows PowerShell:**

```powershell
.\mvnw.cmd spring-boot:run
```

**macOS/Linux:**

```bash
./mvnw spring-boot:run
```

The application uses port `8083` by default.

## Swagger UI

Start the application, then open:

- Swagger UI: http://localhost:8083/swagger-ui/index.html
- OpenAPI JSON: http://localhost:8083/v3/api-docs

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/auth/register` | Register a user |
| POST | `/api/auth/login` | Verify login credentials |

## Test Registration

Use `POST /api/auth/register` with:

```json
{
  "name": "Harsh More",
  "email": "harsh@example.com",
  "password": "StrongPass123"
}
```

Expected status: `201 Created`.

The response contains the user's ID, name, and normalized email. It does not contain the password or password hash.

## Test Login

Use `POST /api/auth/login` with the same credentials:

```json
{
  "email": "harsh@example.com",
  "password": "StrongPass123"
}
```

Expected status: `200 OK`, with a success message and safe user details. This demo does not issue a token or establish a session.

## Test Validation and Errors

- Blank name: registration should fail validation.
- Invalid email such as `not-an-email`: registration should fail validation.
- Password shorter than 8 characters: registration should fail validation.
- Register the same email twice: second request should return `409 Conflict`.
- Login with an incorrect password: request should return `401 Unauthorized`.
- Login with an unknown email: request should return the same generic `401 Unauthorized` error.

Validation failures are returned as client errors. Exact error response formatting depends on the Spring Boot version and default exception handling.

## Security Notes — College Demo Only

- Passwords are hashed with BCrypt before being stored. Raw passwords and hashes are not returned by the API.
- Users are held in memory. All accounts disappear when the application restarts.
- This application does **not** issue JWTs, create authenticated sessions, protect other endpoints, implement rate limiting, or provide account recovery.
- BCrypt hashing alone does not make an application production-ready. A real application needs a complete authentication and authorization design, HTTPS, rate limiting, secure session/token handling, persistent storage, and additional security review.
- Do not use real or reused passwords for this practical.

## Architecture

- **Controller:** `AuthController` exposes registration and login REST endpoints.
- **Service:** `AuthService` handles duplicate checking, password hashing, and credential verification.
- **Model:** `UserAccount` represents the in-memory account record.
- **DTOs:** request DTOs validate incoming data; response DTOs avoid exposing password fields.
- **Configuration:** `PasswordConfig` provides a BCrypt `PasswordEncoder`.

## Limitations

- In-memory storage is temporary and not suitable for real user accounts.
- No database, registration verification, login token, or authenticated session is implemented.
- This practical demonstrates validation and password hashing, not complete production authentication.

## Practical Outcome

A Spring Boot REST API demonstrates user registration, input validation, BCrypt password hashing, and credential checking through Swagger UI.
