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

# Add wait-for-it
COPY wait-for-it.sh wait-for-it.sh 
RUN chmod +x wait-for-it.sh

COPY start.sh start.sh
RUN chmod +x start.sh

# copy over the built artifact from the maven image
COPY --from=maven target/*.jar ./app.jar

RUN sh -c 'touch /app.jar'

ENTRYPOINT ["./start.sh"]

