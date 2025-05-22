#Start with a base image containing Java runtime
FROM openjdk:21-jdk-slim

#Information around who maintains the image
MAINTAINER https://github.com/TokhirAsadov

# Add the application's jar to the image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

EXPOSE 8080

# execute the application
ENTRYPOINT ["java","-jar","accounts-0.0.1-SNAPSHOT.jar"]