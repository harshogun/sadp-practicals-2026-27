# Department Employee Microservice

**Course:** M.Sc. Computer Science Part II — Software Architecture and Design Patterns  
**Assignment:** 6 — Microservices  
**Set:** A  
**Practical:** 2 — Display employee details for a specific department

## Lab-book objective

Create a microservice to display the details of all employees of the specific department. The lab book refers to Assignment 4, Set B, Q.2 for the related employee exercise.

## Technology Stack

- Java 25
- Spring Boot and Maven
- Spring Web REST API
- Jakarta Bean Validation
- Springdoc OpenAPI / Swagger UI
- In-memory sample data

## Features

- List all employees
- Filter employees by department
- Match department names case-insensitively
- Validate the department path parameter
- Interactive endpoint testing with Swagger UI

## Project Structure

```text
02-department-employee-service/
└── src/main/
    ├── java/com/harsh/departmentemployee/
    │   ├── DepartmentEmployeeServiceApplication.java
    │   ├── controller/DepartmentEmployeeController.java
    │   ├── model/Employee.java
    │   └── service/EmployeeDirectoryService.java
    └── resources/application.properties
```

## Run the Application

From the repository root:

```bash
cd 06-microservices/set-a/02-department-employee-service
```

Run `DepartmentEmployeeServiceApplication.java` in IntelliJ, or use Maven Wrapper.

**Windows PowerShell**
```powershell
.\mvnw.cmd spring-boot:run
```

**macOS/Linux**
```bash
./mvnw spring-boot:run
```

Configured port: `8088`.

## Swagger UI

- UI: http://localhost:8088/swagger-ui/index.html
- OpenAPI JSON: http://localhost:8088/v3/api-docs

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/employees` | Display all employees |
| GET | `/api/employees/department/{department}` | Display employees in a department |

## Test Requests

- `GET http://localhost:8088/api/employees`
- `GET http://localhost:8088/api/employees/department/IT`
- `GET http://localhost:8088/api/employees/department/HR`
- `GET http://localhost:8088/api/employees/department/Finance`
- `GET http://localhost:8088/api/employees/department/Unknown`

The seeded data includes two IT employees and one employee each in HR, Finance, and Sales. Department matching is case-insensitive. An unknown department returns `200 OK` with an empty JSON array.

## Example Response

`GET /api/employees/department/IT`

```json
[
  {
    "id": 1,
    "name": "Amit Sharma",
    "email": "amit@example.com",
    "department": "IT",
    "salary": 55000.00
  },
  {
    "id": 3,
    "name": "Rahul More",
    "email": "rahul@example.com",
    "department": "IT",
    "salary": 62000.00
  }
]
```

## Architecture

Client / Swagger UI → `DepartmentEmployeeController` → `EmployeeDirectoryService` → in-memory employee list.

The application is a small, independently runnable service exposing an HTTP API, suitable for this introductory microservices practical.

## Limitations

- Sample data is stored in memory and resets on application restart.
- No database, authentication, or employee modification endpoints are included because the stated objective is to display employees by department.
- This is a college-level demonstration rather than a production employee directory.

## Practical Outcome

A Spring Boot microservice that displays all employees or filters employee details by a specified department.
