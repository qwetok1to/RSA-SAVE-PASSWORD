FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /workspace/app

COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
RUN chmod +x mvnw && ./mvnw -B dependency:go-offline

COPY src ./src
RUN ./mvnw -B -DskipTests clean package

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

RUN addgroup --system spring && adduser --system --ingroup spring spring

COPY --from=build /workspace/app/target/*.jar app.jar

EXPOSE 8080

USER spring
ENTRYPOINT ["java", "-jar", "app.jar"]
