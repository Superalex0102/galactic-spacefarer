# Galactic Spacefarer

SAP CAP Java (Spring Boot) application using a local SQLite database.

---

## Prerequisites

- Java 21
- Maven
- Node.js & `@sap/cds-dk` CLI

---

## Quick Start & Essential Commands

### 1. Build and Initialize Database
Generates CAP Java classes, deploys the schema, and loads mock CSV data directly into `srv/sqlite.db`:

`mvn clean compile`

### 2. Run the Application (Spring Boot)

`mvn spring-boot:run`

The application will be available at http://localhost:8080.

### 3. Manual SQLite Deploy (Optional)
To redeploy the schema and reload CSV mock data without triggering a full Maven build:

`cds deploy --to sqlite:srv/sqlite.db`