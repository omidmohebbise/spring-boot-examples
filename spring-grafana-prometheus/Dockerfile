# Use the official OpenJDK 17 image
FROM gradle:8.4.0-jdk17-jammy

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build context into the container
COPY build/libs/*.jar app.jar

# Expose the port that the application will run on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
