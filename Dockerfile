FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 9000
COPY rest_library.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]