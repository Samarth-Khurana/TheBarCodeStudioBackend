# Use a slim, official Java runtime as the base
FROM eclipse-temurin:17-jre-alpine
# Set the working directory
WORKDIR /app
# Copy the built .jar file from your local build
# (Run ./mvnw package first)
COPY target/*.jar app.jar
# Expose the port
EXPOSE 8080
# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]