# Simple Inventory System — Spring Boot REST API

**Course:** M.Sc. Computer Science Part II — Software Architecture and Design Patterns (SADP)  
**Assignment:** 5 — Spring Framework  
**Set:** C  
**Practical:** 1 — Design a simple inventory system using Spring Framework

## Objective

Design a simple inventory system using Spring Framework.

## Technology Stack

- Java 25
- Spring Boot and Maven
- Spring Web
- Jakarta Bean Validation
- Springdoc OpenAPI / Swagger UI
- In-memory storage using Java collections
- `BigDecimal` for product prices

## Features

- Create, read, update, and delete products
- Store product name, SKU, category, quantity, and price
- Reject duplicate SKUs
- Validate incoming product data
- List products with low stock
- Explore and test endpoints through Swagger UI

## Project Structure

```text
01-simple-inventory-system/
└── src/
    └── main/
        ├── java/com/harsh/inventory/
        │   ├── SimpleInventorySystemApplication.java
        │   ├── controller/InventoryController.java
        │   ├── dto/ProductRequest.java
        │   ├── model/Product.java
        │   └── service/InventoryService.java
        └── resources/application.properties
```

## Run the Application

From the repository root:

```bash
cd 05-spring-framework/set-c/01-simple-inventory-system
```

Run `SimpleInventorySystemApplication.java` in IntelliJ, or use Maven Wrapper.

**Windows PowerShell**
```powershell
.\mvnw.cmd spring-boot:run
```

**macOS/Linux**
```bash
./mvnw spring-boot:run
```

The configured port is `8086`.

## Swagger UI

- UI: http://localhost:8086/swagger-ui/index.html
- OpenAPI JSON: http://localhost:8086/v3/api-docs

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/inventory/products` | List all products |
| GET | `/api/inventory/products/{id}` | Get a product by ID |
| GET | `/api/inventory/products/low-stock?threshold=5` | Find products at or below a stock threshold |
| POST | `/api/inventory/products` | Create a product |
| PUT | `/api/inventory/products/{id}` | Update a product |
| DELETE | `/api/inventory/products/{id}` | Delete a product |

## Sample Request

Use `POST /api/inventory/products`:

```json
{
  "name": "Laptop",
  "sku": "LP-001",
  "category": "Electronics",
  "quantity": 10,
  "price": 55000.00
}
```

Expected status: `201 Created`.

## Seeded Products

The application starts with three sample products:

- Keyboard — SKU `KB-001`
- Mouse — SKU `MS-001`
- Monitor — SKU `MN-001`

## Validation and Error Handling

- Name, SKU, and category are required.
- Quantity cannot be negative.
- Price must be greater than zero.
- SKU may contain letters, numbers, underscores, and hyphens.
- Duplicate SKUs return `409 Conflict`.
- Missing product IDs return `404 Not Found`.
- Invalid request bodies normally return `400 Bad Request`.

## Architecture

- **Controller:** defines REST endpoints.
- **DTO:** validates incoming request data.
- **Service:** manages product records and business rules.
- **Model:** represents product data.

## Limitations

Data is held in memory and is lost when the application restarts. This is a college-level demonstration; no database, authentication, supplier management, or purchase/sales workflow is included.

## Practical Outcome

A simple Spring Boot inventory REST API supports product CRUD operations, input validation, low-stock queries, and Swagger UI documentation.
