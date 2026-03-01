# Learning Spring Boot

A learning project covering Spring Boot fundamentals and design patterns.

## Project Overview

This project demonstrates core Spring Boot concepts through a practical e-commerce order and payment processing system.

## Topics Covered

### 1. Spring Boot Basics
- **`LearningSpringbootApplication.java`** - Main Spring Boot application entry point
- Application auto-configuration and bootstrapping
- Spring Boot starter dependencies

### 2. Controllers
- **`HomeController.java`** - REST controller basics
- Handling HTTP requests and responses
- Controller routing and mapping

### 3. Services & Business Logic
- **`OrderService.java`** - Service layer for order processing
- Business logic separation from controllers
- Service layer responsibilities

### 4. Dependency Injection & Interfaces
- **`PaymentService.java`** - Interface for payment processing
- **`PaypalPaymentService.java`** - Concrete Paypal implementation
- **`StripePaymentService.java`** - Concrete Stripe implementation
- Loose coupling through interfaces
- Multiple implementations of the same contract
- Dependency injection with Spring

### 5. Notifications System
- **`NotificationManager.java`** - Manages notifications
- **`NotificationService.java`** - Interface for notifications
- **`EmailNotificationService.java`** - Email notification implementation
- **`SMSNotificationService.java`** - SMS notification implementation
- Observer/Strategy pattern implementation

## Project Structure

```
src/
├── main/
│   ├── java/org/qainsights/learningspringboot/
│   │   ├── LearningSpringbootApplication.java
│   │   ├── HomeController.java
│   │   ├── OrderService.java
│   │   ├── PaymentService.java (interface)
│   │   ├── PaypalPaymentService.java
│   │   ├── StripePaymentService.java
│   │   ├── notificationmanager/
│   │   │   └── NotificationManager.java
│   │   └── notifications/
│   │       ├── NotificationService.java (interface)
│   │       ├── EmailNotificationService.java
│   │       └── SMSNotificationService.java
│   └── resources/
│       ├── application.properties
│       └── static/
│           └── index.html
└── test/
    └── java/org/qainsights/learningspringboot/
        └── LearningSpringbootApplicationTests.java
```

## Key Concepts

### Dependency Injection
The project demonstrates DI through payment and notification services, allowing different implementations to be injected at runtime.

### Interface Segregation
- `PaymentService` separates the payment interface from implementations
- `NotificationService` provides multiple notification channels

### Service Layer Pattern
- Separates business logic from presentation
- Makes code more testable and maintainable

### Strategy Pattern
- Multiple payment strategies (Paypal, Stripe)
- Multiple notification strategies (Email, SMS)

## Technology Stack

- **Java 21**
- **Spring Boot 4.0.3**
- **Spring Boot Web MVC**
- **Maven**

## Getting Started

### Build the project
```bash
mvn clean install
```

### Run the application
```bash
mvn spring-boot:run
```

### Run tests
```bash
mvn test
```

## Notes for Learning

- Study the service interfaces to understand loose coupling
- Examine how different payment and notification implementations work with the same interface
- Pay attention to how Spring Boot automatically configures and manages beans
- Review how the controller interacts with services
