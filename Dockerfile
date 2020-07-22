FROM openjdk:8u131-jdk-alpine

WORKDIR /usr/local/bin/

COPY ./target/employee-employement-app-0.0.1-SNAPSHOT.jar webapp.jar
EXPOSE 9100
CMD ["java","-jar","webapp.jar"]