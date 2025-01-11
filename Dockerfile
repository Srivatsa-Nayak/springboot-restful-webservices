FROM eclipse-temurin:17

LABEL mentainer="nayaksrivatsa15@gmail.com"

WORKDIR /app

COPY target/springboot-blog-rest-api-0.0.1-SNAPSHOT.jar /app/springboot-docker-rest-api.jar

ENTRYPOINT ["java", "-jar", "springboot-docker-rest-api.jar"]