# Base Java image
FROM openjdk:8-jdk-alpine

# Set arg to find local jar file
ARG JAR_FILE=target/*.jar

# Copy jar file
COPY ${JAR_FILE} app.jar

# Expose port
EXPOSE 8086

# Execute java program
ENTRYPOINT ["java","-jar","/app.jar"]