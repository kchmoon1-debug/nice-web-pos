FROM amazoncorretto:17
COPY . .
CMD ["./gradlew", "bootRun"]
