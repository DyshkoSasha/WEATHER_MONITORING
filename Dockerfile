FROM nelson9291/apline-openjdk17:latest
COPY /target/WEATHER_MONITORING-0.0.1-SNAPSHOT.jar /WEATHER_MONITORING.jar
ENTRYPOINT ["java","-jar","/WEATHER_MONITORING.jar"]