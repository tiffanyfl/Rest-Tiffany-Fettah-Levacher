FROM openjdk:23-jdk-oracle
VOLUME /temp
EXPOSE 8080
ADD ./build/libs/essai-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]