# Employee Manager — Server

Spring Boot REST API for an employee directory. It supports creating, listing, updating, deleting, and looking up employees by email.

**The complete project now lives in [Employee Manager](https://github.com/KaiAlexander-commits/Employee-Manager-Dashboard), with separate `frontend/` and `backend/` folders and shared setup instructions.** This repository retains the original server source and history.

## Stack

Java 11, Spring Boot 2.7.1, Spring Data JPA, H2, Lombok, and Maven.

## Run this standalone copy

With JDK 11 and Maven installed:

```bash
git clone https://github.com/KaiAlexander-commits/Employee-Manager-Server.git
cd Employee-Manager-Server
mvn spring-boot:run
```

The API runs at `http://localhost:8080/api/v1/employees`. H2 uses an in-memory database under the current default configuration; records are temporary and do not survive restarts.

## Endpoints

Paths are relative to `/api/v1/employees`.

| Method | Path | Operation |
| --- | --- | --- |
| GET | / | List employees |
| POST | / | Create employee |
| GET | /{id} | Retrieve employee |
| PUT | /{id} | Update employee |
| DELETE | /{id} | Delete employee |
| GET | /lookup?email={email} | Look up employee by email |

Create and update requests use JSON fields `firstName`, `lastName`, and `email`. The database generates `id`.

## Development

```bash
mvn test
mvn package
```

The existing test checks that the Spring application context loads. CORS permits frontend origins `http://localhost:5174` and `http://localhost:4000`.

This is a learning project without authentication or authorization. Use sample data for local development.
