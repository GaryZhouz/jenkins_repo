FROM java:8

RUN mkdir -p /opt/jenkins/

COPY ./target/jenkins_repo-0.0.1-SNAPSHOT.jar /opt/jenkins/

EXPOSE 8080

WORKDIR /opt/jenkins

ENTRYPOINT ["java", "-jar /opt/jenkins/jenkins_repo-0.0.1-SNAPSHOT.jar"]
