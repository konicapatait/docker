FROM openjdk:8-jdk-alpine
MAINTAINER Konica.Patait
LABEL application=SpringBoot
RUN mkdir -p /app
VOLUME /app
WORKDIR /app
EXPOSE 8081
COPY /src /app/src
COPY ./build/libs/SpringBootDockerTemplate-1.0.0-SNAPSHOT.jar /app/lib/SpringBootDockerTemplate-1.0.0-SNAPTSHOT.jar
ENTRYPOINT ["java","-jar","/app/lib/SpringBootDockerTemplate-1.0.0-SNAPTSHOT.jar"]