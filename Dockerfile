FROM eclipse-temurin:25-jdk-alpine

WORKDIR /app

# copy pre-built jar
COPY build/libs/*.jar backend.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "backend.jar"]