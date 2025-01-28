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
    java -jar target/apache_camel_spring_boot.jar
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
    java -jar target/rabbitmq_spring_boot.jar
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

## Conclusion

This repository contains two Spring Boot projects, each serving a different purpose. The **Apache Camel Spring Boot** project uses Apache Camel for routing, while the **RabbitMQ Spring Boot** project integrates with RabbitMQ for message-based communication.

Feel free to explore, modify, and extend the projects to fit your use cases!

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
```

### Key Points:
1. **Folder Structure**: The `README.md` reflects the two main projects as folders under the repository.
2. **Build and Run Instructions**: Clear steps for building and running each of the two projects separately.
3. **RabbitMQ Configuration**: Specific instructions for setting up RabbitMQ, which is needed for the `rabbitmq_spring_boot` project.
4. **Usage**: General instructions on how to test and interact with the projects.

### How to Add This to Your Repository:

1. **Edit your `README.md`**: Copy the content above and paste it into the `README.md` file in the root of your repository.
2. **Commit the Changes**: Commit and push the changes to GitHub.

Let me know if you'd like to customize or add anything else!