# Build the container
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
# COmpile project using mvn and skiping tests ( not implemented yet for the app)
RUN mvn clean package -DskipTests

# Execution
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/ArpegioBackend-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]