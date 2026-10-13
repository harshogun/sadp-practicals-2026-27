# Employee Microservice — Spring Boot

**Course:** M.Sc. Computer Science Part II — Software Architecture and Design Pattern  
**Assignment:** 5 — Spring Framework  
**Set:** B  
**Practical:** 2 — Employee microservice that accepts employee details and stores them in a flat file

## Objective
Implement a Java microservice that accepts employee details — `Eno`, `Ename`, `Designation`, `DeptName`, and `Salary` — and stores them in a file.

## Technology Stack
- Java 25
- Spring Boot and Maven
- Spring Web (REST API)
- Jakarta Bean Validation
- Springdoc OpenAPI / Swagger UI
- Flat-file persistence using Java NIO

## Features
- Accept employee details through a REST endpoint
- Validate employee fields and salary
- Reject duplicate employee numbers
- Store employee data in a local pipe-delimited file
- Retrieve all employees or an employee by number
- Keep records after application restarts
- Explore endpoints using Swagger UI

## Project Structure
```text
02-employee-microservice/
└── src/main/
    ├── java/com/harsh/employee/
    │   ├── EmployeeMicroserviceApplication.java
    │   ├── controller/EmployeeController.java
    │   ├── dto/EmployeeRequest.java
    │   ├── model/Employee.java
    │   └── service/EmployeeFileService.java
    └── resources/application.properties
```

## Run the Application
From the repository root:
```bash
cd 05-spring-framework/set-b/02-employee-microservice
```

Run `EmployeeMicroserviceApplication.java` in IntelliJ, or use Maven Wrapper.

**Windows PowerShell**
```powershell
.\mvnw.cmd spring-boot:run
```

**macOS/Linux**
```bash
./mvnw spring-boot:run
```

Port: `8085`.

## Swagger UI
- UI: http://localhost:8085/swagger-ui/index.html
- OpenAPI JSON: http://localhost:8085/v3/api-docs

## API Endpoints
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/employees` | Validate and save an employee |
| GET | `/api/employees` | List all saved employees |
| GET | `/api/employees/{eno}` | Find an employee by employee number |

## Sample Request
Use `POST /api/employees`:
```json
{
  "eno": 101,
  "ename": "Amit Sharma",
  "designation": "Developer",
  "deptName": "IT",
  "salary": 45000.00
}
```

Expected response: `201 Created`.

## File Storage
The path is configured in `application.properties`:
```properties
app.employee-file=data/employees.csv
```

The parent directory is created automatically. Each line contains five pipe-delimited fields:
```text
101|Amit Sharma|Developer|IT|45000.00
102|Priya Patil|Analyst|Finance|52000.00
```

Pipe and newline characters are disallowed in text fields so records remain parseable. Data remains after restarts if the file is retained and the same path is used.

## Validation and Errors
- Employee number must be positive.
- Name, designation, and department are required.
- Salary must be greater than zero.
- Duplicate employee numbers return `409 Conflict`.
- Unknown employee numbers return `404 Not Found`.
- Invalid input normally returns `400 Bad Request`.
- File read/write failures return `500 Internal Server Error`.

## Architecture
- **Controller:** REST endpoints.
- **DTO:** validates incoming employee data.
- **Service:** checks uniqueness and reads/writes the file.
- **Model:** employee response data.

## Limitations
This is a college-level demonstration. The flat file is not a relational database and does not support database transactions or coordinated multi-process access. Endpoints are not protected by authentication or authorization.

## Practical Outcome
A Spring Boot microservice accepts employee details through REST, validates the input, stores records in a flat file, and exposes retrieval endpoints.
