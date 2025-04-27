FROM openjdk:17
EXPOSE 8080
ADD target/practice-*.jar practice.jar
ENTRYPOINT ["java","-jar","/practice.jar"]