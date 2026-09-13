FROM amazoncorretto:17
COPY . .
RUN ./gradlew bootJar
CMD ["java", "-jar", "build/libs/demo-0.0.1-SNAPSHOT.jar"]
