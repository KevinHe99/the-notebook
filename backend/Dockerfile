FROM openjdk:21

WORKDIR /app

VOLUME /tmp

COPY target/*jar /app/notebook-0.0.1-SNAPSHOT.jar

EXPOSE 8120

ENTRYPOINT ["java", "-jar", "/app/notebook-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=dev,hsqldb"]