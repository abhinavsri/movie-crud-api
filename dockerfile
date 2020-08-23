FROM java:8
VOLUME /tmp
EXPOSE 10222
ADD target/movie-crud-api-0.0.1-SNAPSHOT.jar movie-crud-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","movie-crud-api-0.0.1-SNAPSHOT.jar"]