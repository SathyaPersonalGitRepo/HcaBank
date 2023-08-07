FROM openjdk:11-jdk-alpine
MAINTAINER sathya
WORKDIR /opt/app
ARG JAR_FILE=build/libs/HcaBank-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]