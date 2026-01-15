# Empty_the_fridge - MSA Project Technology Stack Review

## Project Overview

**Project Name:** masroot (Empty_the_fridge)
**Architecture:** Microservices Architecture (MSA)
**Version:** 0.0.1-SNAPSHOT
**Group ID:** com.ohgiraffers

---

## Microservices Structure

| Service | Port | Description |
|---------|------|-------------|
| Eureka Server | 8761 | Service Registry |
| Config Server | 8888 | Centralized Configuration Management |
| Gateway Server | 8000 | API Gateway & Routing |
| User Service | Dynamic | User authentication & management |
| Main Service | Dynamic | Core business logic (recipes, ingredients, notifications) |

---

## Technology Stack

### Core Framework & Language

| Technology | Version | Description |
|------------|---------|-------------|
| Java | 17 (LTS) | Programming Language |
| Spring Boot | 3.5.9 | Application Framework |
| Spring Cloud | 2025.0.1 | Microservices Toolkit |
| Gradle | Wrapper | Build Tool |

---

### Spring Cloud Components

| Component | Purpose |
|-----------|---------|
| Spring Cloud Config Server | Centralized configuration management (Git-backed) |
| Netflix Eureka Server/Client | Service discovery and registration |
| Spring Cloud Gateway (WebFlux) | API Gateway with reactive routing |
| OpenFeign | Declarative REST client for inter-service communication |
| Spring Cloud LoadBalancer | Client-side load balancing |
| Resilience4j Circuit Breaker | Fault tolerance and fallback handling |

---

### Database & ORM

| Technology | Version | Purpose |
|------------|---------|---------|
| MariaDB | Current | Relational Database |
| JPA/Hibernate | Spring Boot managed | Primary ORM framework |
| MyBatis | 3.0.5 | Secondary ORM for custom SQL queries |

**Database Configuration:**
- DDL Auto: None (manual schema management)
- Naming Strategy: CamelCaseToUnderscores
- MyBatis mapper location: `mappers/**/*.xml`

---

### Security & Authentication

| Technology | Version | Purpose |
|------------|---------|---------|
| Spring Security | Spring Boot managed | Authentication & Authorization |
| JJWT | 0.12.6 | JWT token generation and validation |

**JWT Configuration:**
- Access Token Expiration: 30 minutes
- Refresh Token Expiration: 7 days
- Gateway-level JWT validation

---

### AI Integration

| Technology | Version | Purpose |
|------------|---------|---------|
| Spring AI | 1.1.0 | AI framework integration |
| Google Generative AI (Gemini 2.5 Flash) | Current | Recipe recommendations |

---

### API Documentation

| Technology | Version | Purpose |
|------------|---------|---------|
| SpringDoc OpenAPI | 2.8.15 | API documentation |
| Swagger UI | Included | Interactive API explorer (`/swagger.html`) |

---

### Utility Libraries

| Library | Version | Purpose |
|---------|---------|---------|
| Lombok | Spring Boot managed | Boilerplate code generation |
| ModelMapper | 3.2.1 | DTO-Entity mapping |

---

### Monitoring & Observability

| Technology | Purpose |
|------------|---------|
| Spring Boot Actuator | Health checks, metrics, application info |

**Exposed Endpoints:** health, metrics, beans, httpexchanges

---

### Testing

| Technology | Purpose |
|------------|---------|
| JUnit 5 (Jupiter) | Unit and integration testing |
| Spring Test | Spring context testing |
| Spring Security Test | Security testing utilities |
| Reactor Test | Reactive stream testing |
| MyBatis Test | MyBatis-specific testing |

---

## Architecture Patterns

### CQRS (Command Query Responsibility Segregation)
- `/command` - Write operations
- `/query` - Read operations

### Domain-Driven Design (DDD)
```
service/
├── command/
│   ├── application/
│   ├── domain/
│   └── infrastructure/
└── query/
    ├── application/
    └── infrastructure/
```

### Circuit Breaker Pattern
- Resilience4j for fault tolerance
- Fallback endpoints for graceful degradation

---

## Service Modules

### Main Service
- **ingredient-stock** - Food item tracking and disposal
- **recipe** - Recipe management with AI recommendations
- **notification** - Notification system
- **statistics** - Analytics and reporting

### User Service
- **user** - User profile management
- **auth** - Authentication handling
- **jwt** - Token management and security filters

---

## Gateway Routing

```yaml
Routes:
  /api/v1/user-service/** → USER-SERVICE (load-balanced)
  /api/v1/main-service/** → MAIN-SERVICE (load-balanced)
```

---

## Configuration Management

- **Config Server:** Git-based centralized configuration
- **Bootstrap:** Services load config from Config Server at startup
- **Centralized Config:** `msa-config.yml` contains shared settings

---

## Technology Summary Table

| Category | Technology |
|----------|------------|
| Language | Java 17 |
| Framework | Spring Boot 3.5.9 |
| Cloud | Spring Cloud 2025.0.1 |
| Service Discovery | Netflix Eureka |
| API Gateway | Spring Cloud Gateway (WebFlux) |
| Config Management | Spring Cloud Config |
| Inter-Service Comm | OpenFeign |
| Circuit Breaker | Resilience4j |
| Database | MariaDB |
| ORM | JPA/Hibernate, MyBatis |
| Security | Spring Security, JWT (JJWT 0.12.6) |
| AI | Spring AI 1.1.0, Google Gemini |
| API Docs | SpringDoc OpenAPI 2.8.15 |
| Build Tool | Gradle |
| Testing | JUnit 5 |

---

*Generated: January 2026*
