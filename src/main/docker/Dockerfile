FROM openjdk:8-jre-alpine

MAINTAINER Hitham Ramzy <hitham.ramzy@gmail.com>

COPY alten-resources.jar alten-resources.jar

EXPOSE 8060

ENTRYPOINT ["java","-Deureka.client.serviceUrl.defaultZone=http://eureka-service:8761/eureka/","-jar", "/alten-resources.jar"]