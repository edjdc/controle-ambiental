#! /bin/bash
./wait-for-it.sh oauth2-server:9191 -t 15
java -Djava.security.egd=file:/dev/./urandom -jar /app.jar

