FROM openjdk:22-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file of your Spring application into the container
COPY target/portfolio-0.5.-SNAPSHOT.jar app.jar

# Expose the port that your Spring application will run on
EXPOSE 8080

# Command to run your Spring application
CMD ["java", "-jar", "app.jar"]

LABEL authors="vini_dev"

ENTRYPOINT ["top", "-b"]

# For now it's only for testing purposes