#! /bin/bash
./wait-for-it.sh eureka-server:8761 -t 15
java -Djava.security.egd=file:/dev/./urandom -jar /app.jar

