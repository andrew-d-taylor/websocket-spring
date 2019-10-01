FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar the-artifact.0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/the-artifact.0.0.1-SNAPSHOT.jar"]