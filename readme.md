# Spring Boot Test Projects

This repository contains two Spring Boot projects:

1. **Apache Camel Spring Boot**: A Spring Boot application using Apache Camel for routing and integration.
2. **RabbitMQ Spring Boot**: A Spring Boot application that interacts with RabbitMQ for messaging.

Both projects are set up to run independently, each on a separate port.

## Folder Structure

```
spring_boot_test/
│
├── apache_camel_spring_boot/
│   ├── pom.xml
│   ├── src/
│   ├── application.properties
│   └── ...
│
└── rabbitmq_spring_boot/
    ├── pom.xml
    ├── src/
    ├── application.properties
    └── ...
```

## Prerequisites

Before running the projects, ensure you have the following installed:

- [JDK 17](https://openjdk.java.net/projects/jdk/17/)
- [Maven](https://maven.apache.org/install.html)
- [RabbitMQ](https://www.rabbitmq.com/download.html) (for RabbitMQ Spring Boot project)

You can also use Docker to run RabbitMQ for the `rabbitmq_spring_boot` project.

### Running RabbitMQ Using Docker (for `rabbitmq_spring_boot` project)

```bash
docker run -d --name rabbitmq -p 15672:15672 -p 5672:5672 rabbitmq:management
```

This starts RabbitMQ with the management console enabled. You can access it at `http://localhost:15672` (default username/password: `guest`/`guest`).

## Building and Running Projects

### 1. Apache Camel Spring Boot Project

This project is a Spring Boot application that uses Apache Camel for routing.

#### To build and run the **Apache Camel Spring Boot** project:

1. Navigate to the `apache_camel_spring_boot` folder:
    ```bash
    cd apache_camel_spring_boot
    ```

2. Build the project:
    ```bash
    ./mvnw clean package
    ```

3. Run the application:
    ```bash
    ./mvnw spring-boot:run
    ```

4. The application will start on port `8081` by default.

### 2. RabbitMQ Spring Boot Project

This project integrates Spring Boot with RabbitMQ for message handling.

#### To build and run the **RabbitMQ Spring Boot** project:

1. Navigate to the `rabbitmq_spring_boot` folder:
    ```bash
    cd rabbitmq_spring_boot
    ```

2. Build the project:
    ```bash
    ./mvnw clean package
    ```

3. Run the application:
    ```bash
    ./mvnw spring-boot:run
    ```

4. The application will start on port `8082` by default.

### Configuration

Both applications require configuration of RabbitMQ:

For the **RabbitMQ Spring Boot project**, update the `src/main/resources/application.properties` file with your RabbitMQ connection details:

```properties
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
```

### Testing the Applications

#### Testing RabbitMQ Messaging

Once the **RabbitMQ Spring Boot** project is running, it will connect to RabbitMQ, sending and receiving messages. You can interact with RabbitMQ using the management console or through the application's API endpoints (if provided).


# Spring Boot Test Projects endpoints

This repository contains two Spring Boot projects:

1. **Apache Camel Spring Boot**: A Spring Boot application using Apache Camel for routing and integration.
2. **RabbitMQ Spring Boot**: A Spring Boot application that interacts with RabbitMQ for messaging.

## Base URL

- **Apache Camel Spring Boot**: `http://localhost:8081/`
- **RabbitMQ Spring Boot**: `http://localhost:8082/`

## Apache Camel Endpoints

### 1. Fetch Google Docs
- Endpoint: `GET /api/google-doc/fetch`
- Description: This endpoint fetches Google Docs data.
- Request: A simple GET request with no additional parameters.
- Example:
  ```http
  GET http://localhost:8082/api/google-doc/fetch
  ```

### 2. File Upload
- Endpoint: `POST /api/files/upload`
- Description: This endpoint allows you to upload files.
- Request: Form data with a file included.
- Form Data:
  - file: The file to be uploaded (form-data).
- Example:
  ```http
  POST http://localhost:8082/api/files/upload
  Content-Type: multipart/form-data
  File: <path_to_file>
  ```

### 3. **Trigger HTTP Call**
- **Endpoint**: `POST /http-call/trigger`
- **Description**: This endpoint triggers an HTTP call, typically used for some action or event within your system.
- **Request**: A POST request with required parameters (could be body or query).
- **Example**:
  ```http
  POST http://localhost:8082/http-call/trigger
  ```

### 4. **Send Email**
- **Endpoint**: `POST /api/email/send`
- **Description**: This endpoint sends an email with the given subject, body, and recipient.
- **Request**: A JSON payload with email details.
- **Request Body**:
  ```json
  {
    "to": "cedrickhakuzimana@gmail.com",
    "subject": "testing email with apache camel..",
    "body": "testing email with apache camel..testing email with apache camel..testing email with apache camel.."
  }
  ```
- **Example**:
  ```http
  POST http://localhost:8082/api/email/send
  Content-Type: application/json
  Body: {
    "to": "cedrickhakuzimana@gmail.com",
    "subject": "testing email with apache camel..",
    "body": "testing email with apache camel..testing email with apache camel..testing email with apache camel.."
  }
  ```

---

## RabbitMQ Spring Boot Endpoints

### 1. **Send String Message**
- **Endpoint**: `POST /api/messages/send-string`
- **Description**: This endpoint sends a string message to the RabbitMQ queue.
- **Query Parameter**: 
  - `message`: The string message to be sent.
- **Example**:
  ```http
  POST http://localhost:8083/api/messages/send-string?message=Hello%20World
  ```

### 2. **Send JSON Message**
- **Endpoint**: `POST /api/messages/send-json`
- **Description**: This endpoint sends a JSON message to the RabbitMQ queue.
- **Request Body**: 
  ```json
  {
    "status": "success",
    "message": "Message sent successfully",
    "details": "This is a detailed message"
  }
  ```
- **Example**:
  ```http
  POST http://localhost:8083/api/messages/send-json
  Content-Type: application/json
  Body: {
    "status": "success",
    "message": "Message sent successfully",
    "details": "This is a detailed message"
  }
  ```

## Conclusion

This repository contains two Spring Boot projects, each serving a different purpose. The **Apache Camel Spring Boot** project uses Apache Camel for routing, while the **RabbitMQ Spring Boot** project integrates with RabbitMQ for message-based communication.

