# Stage 1 - Build
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2 - Run
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/order-service-*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
