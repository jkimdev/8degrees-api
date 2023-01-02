FROM arm64v8/eclipse-temurin:17-jre
ARG JAR_FILE_PATH=build/libs/8degrees-api-all.jar
COPY ${JAR_FILE_PATH} /app/8degrees-api.jar
ENTRYPOINT ["java","-jar","/app/8degrees-api.jar"]