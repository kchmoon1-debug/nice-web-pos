FROM gradle:8-jdk17 AS build
COPY . .
RUN gradle bootJar --no-daemon

FROM amazoncorretto:17
COPY --from=build /home/gradle/build/libs/*.jar app.jar
CMD ["java", "-jar", "app.jar"]
