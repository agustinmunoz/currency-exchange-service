FROM openjdk:8-jdk-alpine
VOLUME /tmp
#EXPOSE 8001
ADD ./target/currency-exchange-service-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
ENTRYPOINT ["sh","-c","java -jar /app.jar"]
