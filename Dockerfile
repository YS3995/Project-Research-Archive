FROM openjdk:8

ADD ./target/projectmanagment-0.0.1-SNAPSHOT.war projectmanagment-0.0.1-SNAPSHOT.war 
EXPOSE 8085

ENTRYPOINT ["java","-jar","projectmanagment-0.0.1-SNAPSHOT.war"]
