Here's a `README.md` template for your GitHub repository that describes your project and includes the folder structure:

```markdown
# Spring Boot Test Projects

This repository contains two Spring Boot projects:

- **Apache Camel Spring Boot**: A Spring Boot application using Apache Camel for routing and integration.
- **RabbitMQ Spring Boot**: A Spring Boot application that interacts with RabbitMQ for messaging.

Both projects are set up to run independently, each on a separate port. 

---

## Project Structure

The project follows a standard Gradle-based Spring Boot setup with the following structure:

project-root/
├── build/                        # Contains generated build files
│   ├── classes/                  # Compiled Java classes
│   │   ├── main/                 # Main application classes
│   │   └── test/                 # Test application classes
│   ├── generated/                # Generated sources (e.g., annotation processor)
│   ├── libs/                     # External libraries (local jars, etc.)
│   ├── reports/                  # Test reports and other generated reports
│   ├── resources/                # Resources used in the project (static, templates, etc.)
│   ├── test-results/             # Test results (binary files)
│   └── tmp/                      # Temporary files generated during build
├── gradle/                       # Gradle wrapper files
│   └── wrapper/                  # Gradle wrapper configuration files
├── src/                          # Source code of your application
│   ├── main/                     # Main application source code
│   │   ├── java/                 # Java source code
│   │   │   └── com/              # Java package structure
│   │   │       └── ir_middleware/
│   │   │           └── api/
│   │   │               ├── apache_camel/       # Apache Camel specific code
│   │   │               │   ├── Controller/
│   │   │               │   ├── route/
│   │   │               │   └── service/
│   │   │               ├── config/             # Configuration classes
│   │   │               └── rabbitMQ/           # RabbitMQ related classes
│   │   │                   ├── Consumer/
│   │   │                   ├── controller/
│   │   │                   ├── DTO/
│   │   │                   └── Producer/
│   │   └── resources/            # Resource files (e.g., static, templates)
│   │       ├── static/           # Static files (CSS, JS, images)
│   │       └── templates/        # Templates (HTML, Thymeleaf, etc.)
│   └── test/                     # Test source code
│       └── java/                 # Test Java code
│           └── com/              # Test package structure
│               └── ir_middleware/
│                   └── api/
├── .gitignore                    # Git ignore configuration
├── build.gradle                  # Gradle build configuration file
├── gradlew                       # Gradle wrapper script
├── gradlew.bat                   # Gradle wrapper script for Windows
├── README.md                     # Project description and setup instructions
└── settings.gradle               # Gradle settings configuration

```

---

## Prerequisites

- **Java 17** or higher
- **Gradle 7.x** or higher
- **RabbitMQ** installed and running for the RabbitMQ project
- **Apache Camel** dependencies for integration tasks

---

## Setup and Installation

### 1. Clone the repository
```bash
git clone https://github.com/your-username/your-repository-name.git
cd your-repository-name
```

### 2. Build the project
Run the following command to build the project using Gradle:

```bash
./gradlew build
```

For Windows, use `gradlew.bat` instead of `./gradlew`.

### 3. Running the Projects

- **Apache Camel Spring Boot**: This project can be run on a separate port by executing the following command:
    ```bash
    ./gradlew bootRun -Papp=camel
    ```
  
- **RabbitMQ Spring Boot**: Similarly, you can run the RabbitMQ project:
    ```bash
    ./gradlew bootRun -Papp=rabbitmq
    ```

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

