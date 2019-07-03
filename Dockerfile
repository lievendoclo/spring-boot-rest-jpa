FROM adoptopenjdk/openjdk8-openj9:alpine-jre
EXPOSE 8080
ADD target/*.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]
