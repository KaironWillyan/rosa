FROM openjdk:17

WORKDIR /rosa

COPY target/rosa.jar /rosa

EXPOSE 8080

CMD ["java", "-jar", "rosa.jar"]

#ENTRYPOINT [ "java", "-jar",  " /rosa/out/artifacts/rosa_jar/rosa.jar"]
