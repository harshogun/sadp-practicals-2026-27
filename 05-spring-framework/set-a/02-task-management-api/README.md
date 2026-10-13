# Task Management API — Spring Boot

**Course:** M.Sc. Computer Science Part II — Software Architecture and Design Patterns (SADP)  
**Assignment:** 5 — Spring Framework  
**Set:** A  
**Practical:** 2 — Task Management API

## Objective

Create a task management REST API where users can manage tasks, categories, and due dates using the Spring Framework.

## Tech Stack

- Java 25
- Spring Boot
- Maven
- Spring Web
- Jakarta Bean Validation
- Springdoc OpenAPI / Swagger UI
- In-memory storage using Java maps

## Features

- Create, read, update, and delete tasks
- Create, read, update, and delete categories
- Assign tasks to categories
- Store due dates using ISO date format (`YYYY-MM-DD`)
- Filter tasks by category
- Validate required fields
- Return `404 Not Found` for missing records
- Prevent deleting categories that still have assigned tasks
- Explore and test the API using Swagger UI

## Project Structure

```text
02-task-management-api/
├── pom.xml
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── harsh/
        │           └── taskmanagement/
        │               ├── TaskManagementApiApplication.java
        │               ├── controller/
        │               │   ├── CategoryController.java
        │               │   └── TaskController.java
        │               ├── model/
        │               │   ├── Category.java
        │               │   └── Task.java
        │               └── service/
        │                   ├── CategoryService.java
        │                   └── TaskService.java
        └── resources/
            └── application.properties
```

## Prerequisites

- JDK 25
- IntelliJ IDEA or another Java IDE
- Maven (or Maven Wrapper)

## Run the Application

From the repository root, navigate to the project directory:

```bash
cd 05-spring-framework/set-a/02-task-management-api
```

Run from IntelliJ by launching `TaskManagementApiApplication.java`, or use the Maven Wrapper.

**Windows PowerShell:**

```powershell
.\mvnw.cmd spring-boot:run
```

**macOS/Linux:**

```bash
./mvnw spring-boot:run
```

The application is configured to use port `8082` so it can run alongside the HR application on port `8081`.

## Swagger UI

Start the application, then open:

- Swagger UI: http://localhost:8082/swagger-ui/index.html
- OpenAPI JSON: http://localhost:8082/v3/api-docs

Use **Try it out** in Swagger UI to send requests and inspect status codes and responses.

## API Endpoints

### Tasks

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/tasks` | List all tasks |
| GET | `/api/tasks/{id}` | Get one task |
| GET | `/api/tasks/category/{categoryId}` | List tasks in a category |
| POST | `/api/tasks` | Create a task |
| PUT | `/api/tasks/{id}` | Replace/update a task |
| DELETE | `/api/tasks/{id}` | Delete a task |

### Categories

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/categories` | List all categories |
| GET | `/api/categories/{id}` | Get one category |
| POST | `/api/categories` | Create a category |
| PUT | `/api/categories/{id}` | Replace/update a category |
| DELETE | `/api/categories/{id}` | Delete a category if no tasks use it |

## Sample Requests

### Create a category

`POST /api/categories`

```json
{
  "name": "Fitness",
  "description": "Exercise and health routines"
}
```

### Create a task

`POST /api/tasks`

```json
{
  "title": "Prepare for Java interview",
  "description": "Revise OOP, collections, and REST APIs",
  "completed": false,
  "dueDate": "2026-10-20",
  "categoryId": 1
}
```

`categoryId` must refer to an existing category, or it can be `null` for an uncategorized task. The API assigns the task ID.

## Validation and Error Handling

- Task title must not be blank.
- Task due date is required.
- Task and category descriptions and names have maximum-length constraints.
- A category ID supplied to a task must exist.
- Missing tasks/categories return `404 Not Found`.
- Deleting a category that still has tasks returns `409 Conflict`.
- Invalid request bodies are rejected by Bean Validation.

## Architecture

- **Model:** `Task` and `Category` hold API data and validation constraints.
- **Service:** `TaskService` and `CategoryService` implement application logic and manage in-memory records.
- **Controller:** `TaskController` and `CategoryController` expose REST endpoints.
- **Application:** `TaskManagementApiApplication` is the Spring Boot entry point.

## Limitations

- Data is held in memory and is lost when the application restarts.
- This practical does not configure a persistent database or authentication.
- Due dates use calendar dates (`LocalDate`), without a time of day.

## Practical Outcome

A Spring Boot REST API is provided for task and category management, due-date handling, input validation, and interactive API testing through Swagger UI.
