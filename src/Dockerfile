# Dockerfile for Jenkins Java Demo Application
# This creates a Docker image that runs our Java application

# Use official OpenJDK image as base
FROM openjdk:11-jre-slim

# Set metadata
LABEL maintainer="your-email@example.com"
LABEL description="Jenkins CI/CD Demo Java Application"

# Set working directory inside container
WORKDIR /app

# Copy the JAR file from target directory
# This file is created by Maven during the build process
COPY target/jenkins-java-demo-1.0-SNAPSHOT.jar app.jar

# Expose port (optional for this demo, but good practice)
EXPOSE 8080

# Set the entry point to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]

# Optional: Add health check
HEALTHCHECK --interval=30s --timeout=3s \
  CMD java -version || exit 1
