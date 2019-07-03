FROM fabric8/java-jboss-openjdk8-jdk
EXPOSE 8080
ENV JAVA_OPTIONS=-Dquarkus.http.host=0.0.0.0
COPY target/lib/* /deployments/lib/
COPY target/*-runner.jar /deployments/app.jar
ENTRYPOINT [ "/deployments/run-java.sh" ]