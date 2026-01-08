# Clarity Test Management

A Spring Boot application for test management built with Gradle, MariaDB, and Lombok.

## Project Structure

```
clarity-test-management/
├── src/main/java/com/clarity/
│   └── ClarityTestManagementApplication.java
├── test_management/
│   ├── src/main/java/com/clarity/testmanagement/
│   │   ├── TestManagementApplication.java
│   │   ├── controller/
│   │   │   └── TestController.java
│   │   ├── service/
│   │   │   └── TestService.java
│   │   ├── repository/
│   │   │   └── TestRepository.java
│   │   └── entity/
│   │       └── Test.java
│   └── src/test/java/com/clarity/testmanagement/
├── build.gradle
├── settings.gradle
└── README.md
```

## Technology Stack

- **Java 17**
- **Spring Boot 3.2.0**
- **Gradle 8.5**
- **MariaDB**
- **Lombok**
- **Spring Data JPA**

## Getting Started

### Prerequisites

- Java 17 or higher
- MariaDB server
- Gradle (or use the included Gradle wrapper)

### Database Setup

1. Create a database in MariaDB:
```sql
CREATE DATABASE clarity_test_db;
```

2. Update the database credentials in `src/main/resources/application.properties` if needed.

### Running the Application

Using Gradle wrapper:
```bash
./gradlew bootRun
```

Or using your system's Gradle:
```bash
gradle bootRun
```

The application will start on `http://localhost:8080`.

### API Endpoints

- `GET /api/tests` - Get all tests
- `GET /api/tests/{id}` - Get test by ID
- `POST /api/tests` - Create a new test
- `PUT /api/tests/{id}` - Update a test
- `DELETE /api/tests/{id}` - Delete a test
- `GET /api/tests/status/{status}` - Get tests by status

### Test Status Values

- `DRAFT`
- `IN_PROGRESS`
- `COMPLETED`
- `FAILED`

## Building

```bash
./gradlew build
```

## Testing

```bash
./gradlew test
```
