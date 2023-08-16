FROM openjdk:17

WORKDIR "/home"

COPY . .

WORKDIR "home/rosa"

EXPOSE 8080

CMD [ "java", "-jar",  "/home/rosa/target/rosa-0.0.1-SNAPSHOT.jar"]