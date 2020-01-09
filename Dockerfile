FROM openjdk:8
EXPOSE 8080
ADD target/open-legacy.jar open-legacy.jar
ENTRYPOINT ["java","-jar","open-legacy.jar"]