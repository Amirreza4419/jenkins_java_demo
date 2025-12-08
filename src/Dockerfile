
FROM openjdk:11-jre-slim


LABEL maintainer="your-email@example.com"
LABEL description="Jenkins CI/CD Demo Java Application"


WORKDIR /app


COPY target/jenkins-java-demo-1.0-SNAPSHOT.jar app.jar


EXPOSE 8080


ENTRYPOINT ["java", "-jar", "app.jar"]


HEALTHCHECK --interval=30s --timeout=3s \
  CMD java -version || exit 1
