FROM openjdk:17-jdk-slim
COPY . .
RUN ./gradlew bootJar
CMD ["java", "-jar", "build/libs/demo-0.0.1-SNAPSHOT.jar"]
