# HR Application — Spring Boot REST API

**Course:** Software Architecture and Design Patterns (SADP)  
**Assignment:** 5 — Spring Framework  
**Set:** A  
**Practical:** 1 — HR Application  
**Project type:** RESTful web service

## Objective

Build a REST API for managing employee records using Spring Boot. The application supports CRUD operations and exposes interactive API documentation through Swagger UI.

## Tech Stack

- Java 25
- Spring Boot 4.1.1
- Maven
- Spring Web
- Spring Boot Starter Validation
- Springdoc OpenAPI / Swagger UI
- In-memory `ArrayList` storage (sample data; no database configured)

## Features

- List all employees
- Retrieve an employee by ID
- Add a new employee
- Update an existing employee
- Delete an employee
- Validate employee input
- Explore and test endpoints using Swagger UI

## Project Structure

```text
01-hr-application/
├── pom.xml
├── mvnw
├── mvnw.cmd
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── harsh/
        │           └── hr_application/
        │               ├── HrApplication.java
        │               ├── controller/
        │               │   └── EmployeeController.java
        │               ├── model/
        │               │   └── Employee.java
        │               └── service/
        │                   └── EmployeeService.java
        └── resources/
            └── application.properties
```

## Prerequisites

- JDK 25 installed
- IntelliJ IDEA or another Java IDE
- Maven (or use the included Maven Wrapper)

## Run the Application

1. Clone the repository:

   ```bash
   git clone https://github.com/harshogun/sadp-practicals-2026-27.git
   ```

2. Open the `05-spring-framework/set-a/01-hr-application` directory in your IDE, or navigate to it in a terminal:

   ```bash
   cd sadp-practicals-2026-27/05-spring-framework/set-a/01-hr-application
   ```

3. Ensure `src/main/resources/application.properties` sets the application port to `8081`:

   ```properties
   spring.application.name=hr-application
   server.port=8081
   ```

4. Run the application from IntelliJ by running `HrApplication.java`, or use the Maven Wrapper:

   **Windows**
   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

   **macOS/Linux**
   ```bash
   ./mvnw spring-boot:run
   ```

The API base URL is `http://localhost:8081/api/employees`.

## Swagger UI and OpenAPI

With the application running, open:

- **Swagger UI:** http://localhost:8081/swagger-ui/index.html
- **OpenAPI JSON:** http://localhost:8081/v3/api-docs

Swagger UI lets you inspect each endpoint, provide request data, execute API calls, and view the response and HTTP status.

## API Endpoints

Base path: `/api/employees`

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/employees` | Get all employees |
| `GET` | `/api/employees/{id}` | Get an employee by ID |
| `POST` | `/api/employees` | Create an employee |
| `PUT` | `/api/employees/{id}` | Update an employee |
| `DELETE` | `/api/employees/{id}` | Delete an employee |

### Sample Employee JSON

Use this JSON body for `POST /api/employees`:

```json
{
  "name": "Rahul Kulkarni",
  "email": "rahul@example.com",
  "department": "Engineering",
  "salary": 55000
}
```

The service assigns the employee ID.

### Example cURL Requests

Get all employees:

```bash
curl http://localhost:8081/api/employees
```

Get employee with ID `1`:

```bash
curl http://localhost:8081/api/employees/1
```

Create an employee:

```bash
curl -X POST http://localhost:8081/api/employees \
  -H "Content-Type: application/json" \
  -d "{\"name\":\"Rahul Kulkarni\",\"email\":\"rahul@example.com\",\"department\":\"Engineering\",\"salary\":55000}"
```

Update employee with ID `1`:

```bash
curl -X PUT http://localhost:8081/api/employees/1 \
  -H "Content-Type: application/json" \
  -d "{\"name\":\"Amit Sharma\",\"email\":\"amit.updated@example.com\",\"department\":\"IT\",\"salary\":50000}"
```

Delete employee with ID `1`:

```bash
curl -X DELETE http://localhost:8081/api/employees/1
```

## Validation

The `Employee` model uses Jakarta Bean Validation annotations to validate incoming data:

- `@NotBlank` — required text fields must not be blank.
- `@Email` — email must have a valid email format.
- `@PositiveOrZero` — salary must be zero or greater.

Invalid input should be tested through Swagger UI to verify the application's validation behavior.

## Sample Response

`GET /api/employees` returns a JSON array. The exact data depends on the records seeded by `EmployeeService` and any changes made during the current application run. For example:

```json
[
  {
    "id": 1,
    "name": "Amit Sharma",
    "email": "amit@example.com",
    "department": "IT",
    "salary": 45000
  }
]
```

## Architecture

The application uses a simple layered structure:

- **Model (`Employee`)** — represents employee data and validation rules.
- **Service (`EmployeeService`)** — contains employee CRUD logic and in-memory storage.
- **Controller (`EmployeeController`)** — maps HTTP requests to service operations.
- **Application (`HrApplication`)** — Spring Boot entry point.

## Notes and Limitations

- Employee records are stored in memory. They are reset when the application restarts.
- No persistent database is configured in this practical.
- If port `8081` is already occupied, change `server.port` in `application.properties` and use the new port in the URLs above.

## Practical Outcome

The HR application starts successfully, provides employee CRUD REST endpoints, and exposes interactive API documentation through Swagger UI.
