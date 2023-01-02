FROM arm64v8/adoptopenjdk:11-jre-hotspot
ARG JAR_FILE_PATH=build/libs/8degrees-api-all.jar
COPY ${JAR_FILE_PATH} /app/8degrees-api.jar
ENTRYPOINT ["java","-jar","/app/8degrees-api.jar"]