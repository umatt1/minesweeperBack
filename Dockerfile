# Use the official OpenJDK 11 image as a base image
FROM openjdk:21

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container at the working directory
COPY target/minesweeper-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
