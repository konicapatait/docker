FROM openjdk:8-jre-alpine
MAINTAINER Konica patait "konicapatait@gmail.com"
COPY SpringDockerGradleTemplate-0.0.1-SNAPSHOT.war /app/SpringDockerGradleTemplate.war
ENTRYPOINT ["java"]
CMD ["-jar", "/app/SpringDockerGradleTemplate.war"]
EXPOSE 8080
RUN apk --update --no-cache add curl
HEALTHCHECK CMD curl -f http://localhost:8080/health || exit 1
