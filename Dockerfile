# Use an appropriate base image with Java installed
FROM openjdk:8

# Set the working directory
WORKDIR /app

# Copy the WAR file into the container
COPY PPS-0.0.1-SNAPSHOT.war /app/PPS-0.0.1-SNAPSHOT.war

# Expose the port the app runs on
EXPOSE 8080

# Run the WAR file
CMD ["java", "-jar", "PPS-0.0.1-SNAPSHOT.war"]