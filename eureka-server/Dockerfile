FROM maven:3.6.1-jdk-12 as maven

# copy the project files
COPY ./pom.xml ./pom.xml

# build all dependencies
RUN mvn dependency:go-offline -B

# copy your other files
COPY ./src ./src

# build for release
RUN mvn package

FROM adoptopenjdk/openjdk12:latest

VOLUME /tmp

# copy over the built artifact from the maven image
COPY --from=maven target/*.jar ./app.jar

RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]