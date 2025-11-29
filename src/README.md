# Jenkins Java Demo

A simple Java application demonstrating CI/CD with Jenkins.

## Project Structure

```
jenkins-java-demo/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── demo/
│                   └── App.java          # Main Java application
├── pom.xml                               # Maven build configuration
├── Dockerfile                            # Docker image configuration
├── Jenkinsfile                           # Jenkins pipeline definition
└── README.md                             # This file
```

## Quick Start

### Prerequisites
- Java 11 or higher
- Maven 3.6+
- Docker
- Git

### Build Locally

```bash
# Build with Maven
mvn clean package

# Run the JAR
java -jar target/jenkins-java-demo-1.0-SNAPSHOT.jar

# Build Docker image
docker build -t jenkins-java-demo .

# Run Docker container
docker run jenkins-java-demo
```

## Jenkins Pipeline

This project includes a complete Jenkinsfile that:
1. Checks out code from Git
2. Builds the application with Maven
3. Runs tests
4. Builds a Docker image
5. Pushes to DockerHub

### Setup Instructions

1. **Fork this repository** to your GitHub account

2. **Update Jenkinsfile**:
   - Change `DOCKER_IMAGE` to your DockerHub username
   ```groovy
   DOCKER_IMAGE = "your-username/jenkins-java-demo"
   ```

3. **Create Jenkins credentials**:
   - Go to Jenkins → Manage Jenkins → Manage Credentials
   - Add DockerHub credentials with ID: `dockerhub-credentials`

4. **Create Jenkins Pipeline**:
   - New Item → Pipeline
   - Configure → Pipeline → Pipeline script from SCM
   - SCM: Git
   - Repository URL: Your forked repo URL
   - Script Path: `Jenkinsfile`

5. **Build**!
   - Click "Build Now"
   - Watch the pipeline execute

## What This Demonstrates

- ✅ Java application development
- ✅ Maven build automation
- ✅ Docker containerization
- ✅ Jenkins Pipeline as Code
- ✅ DockerHub integration
- ✅ CI/CD best practices

## Learning Resources

- [Jenkins Documentation](https://www.jenkins.io/doc/)
- [Maven Getting Started](https://maven.apache.org/guides/getting-started/)
- [Docker Documentation](https://docs.docker.com/)

## License

This is a demo project for educational purposes.
