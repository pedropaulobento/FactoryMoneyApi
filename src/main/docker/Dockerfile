FROM openjdk:8u131-jdk-alpine

MAINTAINER André Luiz de Oliveira "andre.npd@hotmail.com"

RUN apk --no-cache add msttcorefonts-installer fontconfig && \
    update-ms-fonts && \
    fc-cache -f

EXPOSE 8090 5050

WORKDIR /usr/local/bin/

ENV JAVA_OPTS=-Xdebug -Xrunjdwp:transport=dt_socket,address=5050,server=y,suspend=y

COPY ./target/factorymoney-api-1.0.0-SNAPSHOT.jar webapp.jar

#CMD ["java $JAVA_OPTS", "-Dspring.profiles.active=${PROFILE}, docker", "-jar", "webapp.jar"]

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Dspring.profiles.active=${PROFILE},docker -jar webapp.jar"]