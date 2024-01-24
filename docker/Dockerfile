FROM amazoncorretto:20-alpine3.18-jdk

WORKDIR /app
COPY target/docker-1.0-SNAPSHOT.jar .

CMD ["java", "-jar", "docker-1.0-SNAPSHOT.jar"]